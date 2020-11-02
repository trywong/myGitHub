package com.test.jdk8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import com.test.jdk8.bean.Person;

public class PersonTest {
    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> persons = Arrays.asList(person1, person2, person3);
        PersonTest test = new PersonTest();
        // 找出persons里面名字是zhangsan的，并且打印出名字
        List<Person> personResult = test.getPersonByUsername("zhhangsan", persons);
        personResult.forEach(person -> System.out.println(person.getUserName()));

        // 找出persons里面年龄大于25的，并且打印出名字
        List<Person> personResult2 = test.getPersonByAge(25, persons);
        personResult2.forEach(person -> System.out.println(person.getUserName()));
    }

    public List<Person> getPersonByUsername(String userName, List<Person> persons) {
        // filter接收一个Predicate类型的函数式接口的实例对象，这个Predicate和Function类似，也是比较重要的函数式接口，大概作用是，接受一个参数，然后做一系列逻辑判断，返回一个布尔值，大概作用就是这样，大概就是说判断给定的传进来的这个参数是不是符合某个规则，符合就返回true，否则就返回false。
        // stream的.collect(Collectors.toList())是把流转换成一个list

        // 解读一下下面这个方法，首先将persons转换成一个流，接着过滤流里面的每一个元素(判断的条件就是这个元素里面的userName属性等于给定的传进来的userName)，最后把这个流转换成一个list进行返回
        return persons.stream().filter(person -> person.getUserName().equals(userName)).collect(Collectors.toList());
    }

    public List<Person> getPersonByAge(int age, List<Person> persons) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (Integer ageOfPerson, List<Person> personList) -> {
            return personList.stream().filter(person -> person.getAge() > ageOfPerson).collect(Collectors.toList());
        };
        return biFunction.apply(age, persons);
    }

    // 当然，上面方法里面自定义的BiFunction函数式接口的实例也可以在外面调用这个方法的时候传进来(动态传进来，动态传进来什么动作，调用的时候就会执行什么动作)
}
