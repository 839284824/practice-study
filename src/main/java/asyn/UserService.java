package asyn;

public class UserService {

    public String getName(){
        try {
            //模拟方法耗时
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "张三";
    }
}
