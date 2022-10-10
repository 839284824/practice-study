package asyn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * 异步工具
 */
@Slf4j
public final class CompletableFutureMain {

    public static void main(String[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        UserService userService = new UserService();
        MedalService medalService = new MedalService();

        //模拟耗时
        Thread.sleep(100);
        //查询用户supplyAsync支持返回值
        CompletableFuture<String> userFuture = CompletableFuture.supplyAsync(userService::getName);
        //其他耗时
        Thread.sleep(100);
        //查询勋章
        CompletableFuture<String> medalFuture = CompletableFuture.supplyAsync(medalService::getMedal);

        //获取结果
        String name = userFuture.get();
        String name1 = userFuture.join();
        String medal = medalFuture.get(2, TimeUnit.SECONDS);

        long endTime = System.currentTimeMillis();

        log.info("我是：" + name + " " + name1 + ",我的勋章：" + medal + " 共耗时：" + (endTime - startTime) + "毫秒");


        //第一个任务
        CompletableFuture<String> firstTask = CompletableFuture.supplyAsync(()->{
            log.info("我是第一个任务");
            return "first";
        });
        //第二个任务
        CompletableFuture sedTask = firstTask.thenRun(()->{
            log.info("我是第二个任务");
        });

        String sed = (String) sedTask.get();

        log.info("任务执行:" + firstTask.get() +" " + sedTask.get() +" "+ sed);



        //第一个任务
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(()->{
            log.info("我是firstFuture");
            return "first";
        });
        //第二个任务
        CompletableFuture secondFuture = firstFuture.thenAccept((param) -> {
            if ("first".equals(param)){
                log.info("我收到了第一个任务的参数");
            }else {
                log.info("我没有收到第一个任务的参数");
            }
        });

        System.out.println("第二个任务："+ secondFuture.get());


    }

}
