package com.wc.app.my_simple_app;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Hello world!
 */
public class App {
    public static void myUpdate(String path) throws Exception {
    }
    
    public static void main(String[] args) throws Exception {
        int first = 1;
        int second = 1;
        System.out.println(first);
        System.out.println(second);
        for (int i = 0; i < 18; i++) {
            int sum = first + second;
            System.out.println(sum);
            first = second;
            second = sum;
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()) {
            Person person = (Person)obj;
            if (person.getName().equals(this.name) && person.getAge() == this.age) {
                return true;
            }
        }
        /*if (obj instanceof Person) {
            Person person = (Person)obj;
            if (person.getName().equals(this.name) && person.getAge() == this.age) {
                return true;
            }
        }*/
        return false;
    }
}

class Student extends Person {
    private String identity;

    public Student(String name, int age, String identity) {
        super(name, age);
    }
}
