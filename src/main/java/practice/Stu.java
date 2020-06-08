package practice;

import lombok.NoArgsConstructor;
import practice.param.PeopleParam;
import practice.param.StuParam;

@NoArgsConstructor
public class Stu extends People {

    @Override
    public String chat(PeopleParam peopleParam) {
        StuParam stuParam = (StuParam) peopleParam;
        return stuParam.getName() + ":" + stuParam.getContent();
    }
}