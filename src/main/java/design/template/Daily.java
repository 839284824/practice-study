package design.template;

import lombok.extern.slf4j.Slf4j;

/**
 * 个人的日常，定义流程
 */
@Slf4j
public abstract class Daily {


    /**
     * 每天日常
     */
    protected void daily(String role) {
        getUp(role);
        eat(role);
        work(role);
        finishWork(role);
        goHome(role);
        play(role);
        sleep(role);
    }

    protected abstract void eat(String role);

    abstract void work(String role);

    abstract void finishWork(String role);

    abstract String getRole();

    abstract void play(String role);


    protected void goHome(String role) {
        log.info(role + ":" + "回家");
    }

    private void sleep(String role) {
        log.info(role + ":" + "睡觉啦");
    }

    private void getUp(String role) {
        log.info(role + ":" + "起床");
    }


}
