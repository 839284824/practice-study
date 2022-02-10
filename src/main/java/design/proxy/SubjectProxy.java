package design.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubjectProxy  implements Subject {

    private Subject subject;

    @Override
    public void print() {
        log.info("I am a proxy");
        if (subject == null){
            subject = new RealSubject();
        }
        subject.print();
        log.info("I am a proxy hhh");
    }
}
