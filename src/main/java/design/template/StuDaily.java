package design.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class StuDaily extends Daily{

    @Override
    public String getRole() {
        return "学生";
    }


    @Override
    public void eat(String role) {
        log.info(role +":早上吃包子");
    }

    @Override
    void work(String role) {
        log.info(role + ":我的工作是好好学习");
    }

    @Override
    void finishWork(String role) {
        log.info(role + ":终于下课啦");
    }


    @Override
    void play(String role) {
        log.info(role + ":王者荣耀");
    }
}
