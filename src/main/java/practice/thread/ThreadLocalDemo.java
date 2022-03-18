package practice.thread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalDemo {


    //相同同线程中传递变量
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    //不同线程中传递变量
    private static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    /**
     * @param args
     */
    public static void main(String[] args) {
        //主线程中保存值
        threadLocal.set("i am threadLocal");
        inheritableThreadLocal.set("i am inheritableThreadLocal");

        new Thread(() -> {
            log.info("子线程中取到的值是" + threadLocal.get());
            log.info("子线程中取到的值是" + inheritableThreadLocal.get());
            log.info("=====================================");

            new Thread(()->{
                log.info("孙子线程中取到的值是" + threadLocal.get());
                log.info("孙子线程中取到的值是" + inheritableThreadLocal.get());
            }).start();
        }
        ).start();
    }
}
