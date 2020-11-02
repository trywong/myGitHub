package com.wc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.wc.domain.Person;
import com.wc.domain.Student;

public class TestMessageService {
    public static void main(String[] args) {
        // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/resource/applicationContext.xml");
        Person person = context.getBean("stu", Student.class);
        person.sendMessage();
    }
}
