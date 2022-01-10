package retry;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author gongzhao
 * guava retry
 */
@Slf4j
public class RetryerInstance {

    public static Retryer getRetryer() {
        return RetryerBuilder.<Boolean>newBuilder()
                //retryIf 重试条件
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfException(Predicates.equalTo(new Exception()))
                //等待策略：每次请求间隔1s
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))
//                .withWaitStrategy(WaitStrategies.noWait())
                //停止策略 : 尝试请求3次
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .build();
    }

    public static void main(String[] args) throws ExecutionException, RetryException {
       String result  = (String)getRetryer().call(new Callable() {
            @Override
            public Object call() throws Exception {
                return mockRetry();
            }
        });
        log.info(result);
    }

    private static String mockRetry(){
        log.error("i am error");
        throw  new RuntimeException();
    }

}
