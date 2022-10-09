package merge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QueueMain {

    public static void main(String[] args) {
        QueueManager queueManager = new QueueManager(5);
        for (int i = 0 ; i < 20; i++){
            boolean result = queueManager.offer(i);
            log.info("QueueClient offer index: " + i + " result：" + result);
        }
    }
}
