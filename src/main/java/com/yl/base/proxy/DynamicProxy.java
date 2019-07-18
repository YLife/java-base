package com.yl.base.proxy;

import com.yl.base.spi.Female;
import com.yl.base.spi.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("主方法执行前...");
        method.invoke(target, args);
        System.out.println("主方法执行后...");
        return null;
    }

    public static void main(String[] args) {
        Female female = new Female();
        Person person = (Person) Proxy.newProxyInstance(female.getClass().getClassLoader(), female.getClass().getInterfaces()
                , new DynamicProxy(female));
        person.sayHello();
    }

}
