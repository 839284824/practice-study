package asyn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * 异步工具
 */
@Slf4j
public final class CompletableFutureMain {

    public static void main(String[] args) throws Exception{

        long startTime =  System.currentTimeMillis();

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
        String medal = medalFuture.get(2,TimeUnit.SECONDS);

        long endTime =  System.currentTimeMillis();

        log.info("我是："+name+",我的勋章："+medal + " 共耗时："+(endTime-startTime) + "毫秒");


    }

}
