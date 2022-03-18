package practice.thread;

import com.alibaba.ttl.TransmittableThreadLocal;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * 异步线程池之间相互传递变量
 */
@Slf4j
public final class TransmitThreadUtil {

    private static TransmittableThreadLocal<Map<String, String>> threadLocal = new TransmittableThreadLocal(true){
        @Override
        public Map<String, String> initialValue() {
            return new HashMap<>(16);
        }
    };


    public static void put(String key, String value) {
        try {
            threadLocal.get().put(key, value);
        } catch (Exception e) {

        }
    }

    public static String get(String key) {
        try {
            return threadLocal.get().get(key);
        } catch (Exception e) {
            return "";
        }
    }

    public static void main(String[] args) {
        TransmitThreadUtil.put("aaid","test");
        TransmitThreadUtil.put("traceId","adsad");
        log.info(TransmitThreadUtil.get("aaid"));
        log.info(TransmitThreadUtil.get("traceId"));
    }

}
