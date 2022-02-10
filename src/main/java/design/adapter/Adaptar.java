package design.adapter;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Adaptar implements Target{

    private Adaptee adaptee;

    public Adaptar(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void say() {
        log.info("我是适配器");
        adaptee.say();
    }
}
