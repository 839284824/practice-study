package asyn;

public class MedalService {

    public String getMedal(){
        try {
            //模拟方法耗时
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "王者";
    }
}
