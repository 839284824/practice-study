package design.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * 被适配者
 */
@Slf4j
public class Adaptee {

    public void say(){
        log.info("我是被适配者");
    }
}
