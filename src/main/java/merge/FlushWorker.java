package merge;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
 * @desc 追加到本地队列的工作类，消费者
 * @author zhaogong
 * @time 4:12 下午 2022/10/8
 **/
@Slf4j
@Data
public class FlushWorker<T> implements Runnable {


    FlushWorker(int queueSize){
        this.queue = new ArrayBlockingQueue<>(queueSize);
        this.flushProcess = new FlushProcess();
    }

    /**
     * 存储队列
     */
    private BlockingQueue<T> queue;
    private FlushProcess flushProcess;

    /*
     * @desc 添加到队列中,添加成功后启动该线程
     * @author zhaogong
     * @time 3:53 下午 2022/10/8
     * @param t
     * @return boolean
     **/
    public boolean add(T t) {
        return queue.offer(t);
    }


    /*
     * @desc 所有的元素出队列并放到list集合中
     * @author zhaogong
     * @time 4:39 下午 2022/10/8
     * @param list
     * @return int
     **/
    public int drainTo(List<T> list){
       return queue.drainTo(list);
    }


    @Override
    public void run() {
        List<T> buffer = new ArrayList<>(queue.size());
        //从本地队列中取出元素
        drainTo(buffer);
        //flush到磁盘或者DB
        flushProcess.flush(buffer);
    }
}
