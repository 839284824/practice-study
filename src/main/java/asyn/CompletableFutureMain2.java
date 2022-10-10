package asyn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * 异步工具
 */
@Slf4j
public final class CompletableFutureMain2 {

    public static void main(String[] args) throws Exception {

        //第一个任务
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(() -> {
            log.info("我是firstFuture");
            return "first";
        });

        //第二个任务
        CompletableFuture<String> secondFuture = firstFuture.whenComplete((param, throwable) -> {
            log.info("上个任务执行完啦，还把" + param + "传过来");
            if ("first".equals(param)) {
                log.info("我收到了第一个任务的参数");
            } else {
                log.info("我没有收到第一个任务的参数");
            }
        });

        log.info("第二个任务：" + secondFuture.get());
}
}
