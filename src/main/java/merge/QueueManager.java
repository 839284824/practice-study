package merge;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @desc 队列管理
 * @author zhaogong
 * @time 3:48 下午 2022/10/8
 **/
@Slf4j
@Data
public class QueueManager<T>{

     public QueueManager(int workSize){

         this.executorService = Executors.newFixedThreadPool(10) ;
         this.workers = new ArrayList<>(10);

        for (int i = 0 ; i < workSize ; i++ ){
            FlushWorker flushWorker = new FlushWorker(1000);
            workers.add(flushWorker);
            executorService.submit(flushWorker);
        }
    }

    private int writeIndex = 0;

    /**
     * 工作队列
     */
    private List<FlushWorker<T>> workers;

    /**
     * 线程池管理工作线程
     */
    private ExecutorService executorService;

    /*
     * @desc 添加元素
     * @author zhaogong
     * @time 4:44 下午 2022/10/8
     * @param t
     * @return boolean
     **/
    public  boolean offer(T t) {
        int index = writeIndex/workers.size();
        boolean res = workers.get(index).add(t);
        if (res) {
            writeIndex++;
        }
        return res;
    }
}
