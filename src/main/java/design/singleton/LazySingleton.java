package design.singleton;

/**
 * 懒汉式
 */
public class LazySingleton {

    //保证在所有线程同步
    private static volatile LazySingleton lazySingleton = null;

    /**
     * 私有化构造函数
     */
    private LazySingleton(){};

    public static synchronized LazySingleton getInstance(){
        //懒汉式加载，需要的时候才加载
        if (lazySingleton ==null){
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }
}
