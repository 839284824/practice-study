package asyn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 异步工具
 */
@Slf4j
public final class CompletableFutureMain1 {

    public static void main(String[] args) throws Exception {

        //第一个任务
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(() -> {
            log.info("我是firstFuture");
            return "first";
        });
        //第二个任务
        CompletableFuture<String> secondFuture = firstFuture.thenApply((param) -> {
            if ("first".equals(param)) {
                log.info("我收到了第一个任务的参数");
                return "secondFuture";
            } else {
                log.info("我没有收到第一个任务的参数");
                return "没收到";
            }
        });
        log.info("第二个任务：" + secondFuture.get());


    //异常任务
    CompletableFuture<String> errorFuture = CompletableFuture.supplyAsync(() -> {
        log.info("我是errorFuture:" + Thread.currentThread().getName());
        throw new RuntimeException();
    });
    //第二个任务
    CompletableFuture<String> exceptionFuture = errorFuture.exceptionally((e) -> {
        e.printStackTrace();
        return "你的程序异常啦";
    });
    log.info("exceptionFuture:"+exceptionFuture.get());
}
}
