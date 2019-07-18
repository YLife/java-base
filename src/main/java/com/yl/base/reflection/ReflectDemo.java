package com.yl.base.reflection;

import java.lang.reflect.Method;

public class ReflectDemo {

    private String qulifiedClassName;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

    public ReflectDemo(String qulifiedClassName, String methodName, Class<?>[] parameterTypes, Object[] parameters) {
        this.qulifiedClassName = qulifiedClassName;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.parameters = parameters;
    }

    public String getQulifiedClassName() {
        return qulifiedClassName;
    }

    public void setQulifiedClassName(String qulifiedClassName) {
        this.qulifiedClassName = qulifiedClassName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public static void main(String[] args) throws Exception {
        Class<?>[] parameterTypes = new Class<?>[]{String.class};
        Object[] objects = new Object[]{"apple"};
        // 反射调用无参方法
        ReflectDemo reflectDemo = new ReflectDemo("com.yl.base.reflection.impl.Female", "sayHello", null, null);
        // 反射调用带参方法
        //ReflectDemo reflectDemo = new ReflectDemo("com.yl.base.reflection.impl.Female", "eat", parameterTypes, objects);
        Class clazz = Class.forName(reflectDemo.getQulifiedClassName());
        // 带参方法
        //Method method = clazz.getMethod(reflectDemo.getMethodName(), parameterTypes);
        // 无参方法
        Method method = clazz.getMethod(reflectDemo.getMethodName());
        method.invoke(clazz.newInstance(), reflectDemo.getParameters());
    }
}
