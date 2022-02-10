package design.singleton;

/**
 * 饿汉式
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton  = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }
}
