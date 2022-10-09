package cache;

import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class LocalingCacheDemo {

    LocalingCacheDemo() {
        RemovalListener<String, String> listener = notification -> System.out.println("[" + notification.getKey() + ":" + notification.getValue() + "] is removed!");
        loadingCache
                //CacheBuilder的构造函数是私有的，只能通过其静态方法newBuilder()来获得CacheBuilder的实例
                = CacheBuilder.newBuilder()
                //设置并发级别为8，并发级别是指可以同时写缓存的线程数.一般设置并发级别为cpu核心数
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                //设置写缓存后过期时间
                .expireAfterWrite(3, TimeUnit.SECONDS)
                //设置缓存容器的初始容量为10
                .initialCapacity(100)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(1000)
                //设置要统计缓存的命中率,会消耗一些性能，生产环境谨慎使用
                .recordStats()
                //设置缓存的移除通知默认情况下，监听器方法是在移除缓存时同步调用的。因为缓存的维护和请求响应通常是同时进行的，代价高昂的监听器方法在同步模式下会拖慢正常的缓存请求。在这种情况下，你可以使用RemovalListeners.asynchronous(RemovalListener, Executor)把监听器装饰为异步操作。
                .removalListener(listener)
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String cacheKey) {
                        return cacheKey;
                    }
                });
    }


    private static LoadingCache<String, String> loadingCache;


    public String getFromCache(String key) {
        try {
            return loadingCache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void put(String key,String value) {
        loadingCache.put(key, value);
    }


    public CacheStats stats(){
        return loadingCache.stats();
    }
}
