package hystrix;

import com.netflix.hystrix.*;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Supplier;

@Slf4j
public class HystrixCommandUtil {

    private final static int DEFAULT_TIMEOUT = 50;
    private final static String DEFAULT_COMMAND_NAME = "default-command";

    public static Builder builder() {
        return new Builder();
    }


    private static class HystrixCommandExe<T> extends HystrixCommand<T> {
        private final String commandName;
        private final Supplier<T> supplier;
        private final T fallbackValue;
        private int timeOut;

        public HystrixCommandExe(Builder builder) {
            super(
                    Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(builder.getCommandName()))
                            .andCommandKey(HystrixCommandKey.Factory.asKey(builder.getCommandName()))
                            .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey(builder.getCommandName()))
                            .andCommandPropertiesDefaults(
                                    HystrixCommandProperties.Setter()
                                            .withExecutionIsolationStrategy(ExecutionIsolationStrategy.THREAD)
                                            .withExecutionTimeoutEnabled(true)
                                            .withExecutionTimeoutInMilliseconds(builder.getTimeOut())
                                            .withCircuitBreakerEnabled(true)
                                            .withCircuitBreakerErrorThresholdPercentage(60)
                            )
                            .andThreadPoolPropertiesDefaults(
                                    HystrixThreadPoolProperties.Setter()
                                            .withCoreSize(15)
                                            .withMaximumSize(20)
                            ));
            this.commandName = builder.commandName;
            this.supplier = builder.supplier;
            this.fallbackValue = (T) builder.getFallbackValue();
            this.timeOut = builder.getTimeOut();
        }

        @Override
        protected T getFallback() {
            try {
                log.error("command:" + commandName + ":timeout:" + timeOut + ":fallback value:" + fallbackValue);
                return fallbackValue;
            } catch (Exception ex) {
                return null;
            }
        }

        @Override
        protected T run() throws InterruptedException {
            try {
                return supplier.get();
            } catch (Exception e) {
                throw e;
            }
        }
    }


    @Getter
    public static class Builder<T> {
        /**
         * command名称
         */
        private String commandName = DEFAULT_COMMAND_NAME;
        /**
         * rpc提供者
         */
        private Supplier<T> supplier;
        /**
         * 熔断降级
         */
        private T fallbackValue;
        /**
         * 降级时间
         */
        private int timeOut = DEFAULT_TIMEOUT;

        private Builder() {
        }

        public Builder<T> setCommandName(String commandName) {
            this.commandName = commandName;
            return this;
        }

        public Builder<T> setSupplier(Supplier<T> supplier) {
            this.supplier = supplier;
            return this;
        }

        public Builder<T> setFallbackValue(T fallbackValue) {
            this.fallbackValue = fallbackValue;
            return this;
        }

        public Builder<T> setTimeOut(int timeOut) {
            this.timeOut = timeOut;
            return this;
        }

        public HystrixCommandExe build() {
            return new HystrixCommandExe(this);
        }
    }


    public static void main(String[] args) {
        String result = (String) HystrixCommandUtil.builder().
                setCommandName("test").
                setFallbackValue("I am fallbackValue").
                setTimeOut(100).
                setSupplier(() -> mockRpc()).
                build().execute();
        System.out.println(result);
    }

    public static String mockRpc() {
        throw new RuntimeException();
//        return "hi";
    }


}
