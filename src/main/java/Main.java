import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Main {

    public static void main(String[] args) throws Exception {

        String json = "{'did':'+idOF2KNky4CAWoLKdTv1TgV'}";


        JSONObject jsonObject = JSON.parseObject(URLDecoder.decode(URLEncoder.encode(json)));

        System.out.println("jsonObject:" + jsonObject.get("did"));


    }
}
