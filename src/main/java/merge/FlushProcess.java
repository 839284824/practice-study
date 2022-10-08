package merge;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * @author zhaogong
 * @time 4:12 下午 2022/10/8
 **/
@Slf4j
public class FlushProcess<T>{


    public void flush(List<T> buffer) {
        log.info("flush to ....");
    }
}
