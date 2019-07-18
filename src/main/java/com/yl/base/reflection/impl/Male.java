package com.yl.base.reflection.impl;

import com.yl.base.reflection.Person;

public class Male implements Person {

    @Override
    public void sayHello() {
        System.out.println("Hello, i am male.");
    }

    @Override
    public void eat(String fruit) {
        System.out.println("I want to eat：" + fruit);
    }

}
