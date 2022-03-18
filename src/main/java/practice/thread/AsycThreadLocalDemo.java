package practice.thread;

import cn.hutool.cron.task.RunnableTask;
import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TransmittableThreadLocal
 * 使用线程池的场景下传递参数
 * https://github.com/alibaba/transmittable-thread-local#-maven%E4%BE%9D%E8%B5%96
 */
@Slf4j
public class AsycThreadLocalDemo {


    //不同线程中传递变量
    private static TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        transmittableThreadLocal.set("I am transmittableThreadLocal");

        //方式1
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                log.info("原生线程中的取到的值：" + transmittableThreadLocal.get());
            }
        });
        //方式2 装饰线程
        Runnable ttlRunnable = TtlRunnable.get(new Runnable() {
            @Override
            public void run() {
                log.info("被装饰的线程中的取到的值：" + transmittableThreadLocal.get());
            }
        });
        executorService.submit(ttlRunnable);

        //方式3 ： 装饰线程池
        // 额外的处理，生成修饰了的对象executorService
        ExecutorService executorServiceTemp = TtlExecutors.getTtlExecutorService(executorService);
        executorServiceTemp.submit(new Runnable() {
            @Override
            public void run() {
                log.info("被装饰的线程池的取到的值：" + transmittableThreadLocal.get());
            }
        });
    }
}
