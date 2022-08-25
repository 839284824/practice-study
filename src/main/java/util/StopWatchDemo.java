package util;


import org.springframework.util.StopWatch;

public class StopWatchDemo {


    /*
     * @desc
     * @author zhaogong
     * @time 3:52 下午 2022/8/25
     * @param args
     **/
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch("测试stopWatch");

        // 任务一模拟休眠3秒钟
        stopWatch.start("TaskOneName");
        Thread.sleep(1000 * 3);
        System.out.println("当前任务名称：" + stopWatch.currentTaskName());
        stopWatch.stop();

        // 任务2模拟休眠10秒钟
        stopWatch.start("TaskTwoName");
        Thread.sleep(1000 * 5);
        System.out.println("当前任务名称：" + stopWatch.currentTaskName());
        stopWatch.stop();

        // 任务3模拟休眠10秒钟
        stopWatch.start("TaskThreeName");
        Thread.sleep(1000 * 5);
        System.out.println("当前任务名称：" + stopWatch.currentTaskName());
        stopWatch.stop();

        // 打印出耗时占比
        System.out.println(stopWatch.prettyPrint());
        //打印出总耗时
        System.out.println(stopWatch.shortSummary());
        // stop后它的值为null
        System.out.println(stopWatch.currentTaskName());

        // 最后一个任务的相关信息
        System.out.println(stopWatch.getLastTaskName());
        System.out.println(stopWatch.getLastTaskInfo());

        // 任务总的耗时 如果你想获取到每个任务详情（包括它的任务名、耗时等等）可使用
        System.out.println("当前秒表：" + stopWatch.getId());
        System.out.println("所有任务总耗时：" + stopWatch.getTotalTimeMillis());
        System.out.println("任务总数：" + stopWatch.getTaskCount());
        System.out.println("所有任务详情：" + stopWatch.getTaskInfo());
    }
}
