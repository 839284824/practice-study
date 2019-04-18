package practice;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Desc
 * @Author gongzhao
 * @Date 2019/4/1818:36
 */
@Slf4j
public class BasicFuture {


    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //异步计算
        Future<Integer> sum = executorService.submit(() -> {
            return 10;
        });

        //1,获取异步的计算结果，阻塞当前线程
        sum.get();
        log.info("sum:{}", sum.get());
        //2，轮询获取结果,耗费CPU资源,而且也不能及时地得到计算结果
        while (!sum.isDone()) {
            //处理结果
            log.info("sum:{}", sum);
        }

    }
}
