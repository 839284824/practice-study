package asyn;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

/**
 * 异步工具
 */
@Slf4j
public final class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture   cf = CompletableFuture.runAsync(()-> log.info("I am test"));
    }

}
