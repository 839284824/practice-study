package util.json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Person {

    private int id;

    @JSONField(serialize = false)
    private int age;
}
