package com.yl.base.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestSPI {

    public static void main(String[] args) {
        ServiceLoader<Person> loader = ServiceLoader.load(Person.class);
        Iterator<Person> iterator = loader.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            System.out.println(person.getClass().getClassLoader());
            person.sayHello();
        }
    }

}
