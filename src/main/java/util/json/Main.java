package util.json;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) throws Exception{
        Home home = new Home();
        Father father = new Father();
        father.setId(1);
        father.setName("爸爸");
        father.setAge(32);
        home.setPerson(father);
        log.info(JSON.toJSONString(home));
    }
}
