package com.yl.base.clone;

import java.io.IOException;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        // 浅克隆测试
        CloneTemp cloneTemp = new CloneTemp(1, "007");
        ShallowClone shallowClone = new ShallowClone(1, cloneTemp);
        ShallowClone shallowCloneTemp = (ShallowClone) shallowClone.clone();
        System.out.println(shallowClone.toString());
        System.out.println(shallowCloneTemp.toString());
        shallowCloneTemp.getCloneTemp().setId(2);
        shallowCloneTemp.getCloneTemp().setName("101");
        System.out.println(shallowClone.toString());
        System.out.println(shallowCloneTemp.toString());
        System.out.println("=====深、浅克隆测试分割线======");
        // 深克隆测试（普通实现）
        DeepClone deepClone = new DeepClone(1, cloneTemp);
        DeepClone deepCloneTemp = (DeepClone) deepClone.clone();
        System.out.println(deepClone.toString());
        System.out.println(deepCloneTemp.toString());
        deepCloneTemp.getCloneTemp().setId(3);
        deepCloneTemp.getCloneTemp().setName("110");
        System.out.println(deepClone.toString());
        System.out.println(deepCloneTemp.toString());
        // 深克隆测试（序列化方式）
        System.out.println("=====序列化方式深克隆测试分割线=====");
        DeepClone deepClone1 = (DeepClone) deepClone.deepCloneBySerialize();
        System.out.println(deepClone1.toString());
        deepClone1.getCloneTemp().setId(4);
        deepClone1.getCloneTemp().setName("120");
        System.out.println(deepClone.toString());
        System.out.println(deepClone1.toString());
        System.out.println(deepCloneTemp.toString());
    }
}
