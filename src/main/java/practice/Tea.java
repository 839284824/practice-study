package practice;

import lombok.extern.slf4j.Slf4j;
import practice.param.PeopleParam;
import practice.param.StuParam;

@Slf4j
public class Tea extends People {

    @Override
    public String chat(PeopleParam peopleParam) {
        if (peopleParam instanceof StuParam){
            log.info("lalala");
        }
        return peopleParam.getContent();
    }
}