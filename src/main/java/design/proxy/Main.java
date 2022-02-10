package design.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        //静态代理
        Subject proxy = new SubjectProxy();
        proxy.print();

        //动态代理
        RealSubject realSubject  = new RealSubject();
        DynamicProxy dynamicProxy = new DynamicProxy(realSubject);
        Subject proxy1 = (Subject) Proxy.newProxyInstance(realSubject.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),dynamicProxy);
        proxy1.print();
    }
}
