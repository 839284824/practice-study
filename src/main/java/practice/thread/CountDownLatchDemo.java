package practice.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class CountDownLatchDemo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        log.info("加载中...");
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                countDownLatch.countDown();
                log.info(Thread.currentThread().getName() + "加载完成");
            }).start();
        }
        try {
            // 这里阻塞等待状态的完成
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("所有人加载完成，开始");
    }
}
