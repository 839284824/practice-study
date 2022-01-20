package util.json;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception{
        Home home = new Home();
        Person father = Father.class.newInstance();
        Field[] fields = Father.class.getFields();
        for (Field field : fields){
            if (field.getName().equals("name")){
                field.set(father,"爸爸");
                continue;
            }
            if (field.getName().equals("id")){
                field.set(father,1);
            }
        }
        home.setPerson(father);
        log.info(JSON.toJSONString(home));
    }
}
