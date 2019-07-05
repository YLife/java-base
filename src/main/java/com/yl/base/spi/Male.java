package com.yl.base.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class Male implements Person {

    @Override
    public void sayHello() {
        System.out.println("Hello, female!");
    }

    public static void main(String[] args) {
        ServiceLoader<Person> s = ServiceLoader.load(Person.class);
        Iterator<Person> iterator = s.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            person.sayHello();
        }
    }

}
