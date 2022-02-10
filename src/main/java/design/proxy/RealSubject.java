package design.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealSubject implements Subject{
    @Override
    public void print() {
        log.info("i am a real subject");
    }
}
