package design.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 装饰器
 */
@Slf4j
public class Decorator implements Component {
    private Component component;

    public Decorator(Component component){
        this.component = component;
    }


    @Override
    public void say() {
        log.info("开始装饰啦");
        component.say();
        log.info("结束装饰啦");
    }
}
