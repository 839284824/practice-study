package design.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component{

    @Override
    public void say() {
        log.info("我是具体的组件");
    }
}
