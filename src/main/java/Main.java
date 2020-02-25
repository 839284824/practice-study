import com.google.common.cache.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    public static void main(String[] a) throws Exception {

        LoadingCache<String, String> cahceBuilder =
                CacheBuilder.newBuilder().maximumSize(1).
                        refreshAfterWrite(2, TimeUnit.MILLISECONDS)
                        .removalListener(new RemovalListener() {
                            @Override
                            public void onRemoval(RemovalNotification removalNotification) {
                                log.info("removalNotification ");
                            }
                        })
                        .build(new CacheLoader() {
                            @Override
                            public Object load(Object o) throws Exception {
                                String va = "hello" + o;
                                log.info("hello" + o);
                                return va;
                            }
                        });

        cahceBuilder.get("jerry");
        cahceBuilder.get("peida");
        cahceBuilder.get("jerry1");
    }

}
