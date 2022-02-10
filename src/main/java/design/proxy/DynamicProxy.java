package design.proxy;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Data
@Slf4j
public class DynamicProxy implements InvocationHandler {

    private Object object;

    public DynamicProxy(Object object){
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("动态代理执行前:{}",method.getName());
        method.invoke(object,args);
        log.info("动态代理执行后:{}",method.getName());
        return null;
    }
}
