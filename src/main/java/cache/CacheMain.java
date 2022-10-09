package cache;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheMain {

    public static void main(String[] args) throws Exception {
        LocalingCacheDemo localingCacheDemo = new LocalingCacheDemo();
        localingCacheDemo.put("A","aaa");
        localingCacheDemo.put("B","bbb");
        localingCacheDemo.put("C","ccc");

        log.info(localingCacheDemo.getFromCache("A"));
        log.info(localingCacheDemo.getFromCache("B"));
        log.info(localingCacheDemo.getFromCache("C"));
        log.info(localingCacheDemo.getFromCache("D"));
        log.info(localingCacheDemo.getFromCache("A"));

        Thread.sleep(5000);
        log.info(" sleep 5s , key:A ,value:" + localingCacheDemo.getFromCache("A"));
    }
}
