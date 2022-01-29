package design.template;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoderDaily extends Daily {




    @Override
    protected void eat(String role) {
        log.info(role + ":早上吃油条");
    }

    @Override
    void work(String role) {
        log.info(role + ":好好搬砖");
    }

    @Override
    void finishWork(String role) {
        log.info(role + ":摸鱼。。。");
    }

    @Override
    protected String getRole() {
        return "码农";
    }

    @Override
    void play(String role) {
        log.info(role + ":琅琊榜");
    }
}
