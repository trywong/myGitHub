package com.test.jdk8.methodreference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceTest {

    public static void main(String[] args) {
        Student student = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student, student2, student3, student4);
        // 从java8开始List类里提供了一个默认的(default)sort方法用于排序使用。使用传统lambda表达式的实现方式如下
        students.sort((studentParam1, studentParam2) -> Student.compareStudentByScore(studentParam1, studentParam2));
        students.forEach(item -> System.out.println(item.getScore()));
        System.out.println("=========================================================");
        // 使用方法引用代替lambda的实现方式写法如下(类名::静态方法名 的方式)：
        // 这里为什么可以用方法引用的方式呢？因为上面的lamba接收的是两个参数，实现里面其实本身就调用了一个compareStudentByScore方法，而这个方法本身就是现成的，就是存在的，这种情况下就可以使用方法引用
        // 这里就是第一种方法引用：类名::静态方法名
        // 这种实现方式完全等价于上面lambda那种实现方式，为什么呢？因为对于sort方法来说，它里面的函数式接口Comparator里面的抽象方法compare方法要求接收两个类型相同的参数，返回一个整型，而Student类里面的compareStudentByScore静态方法就是按照这个规则定义的，所以就可以这么用方法引用，所以这种方式就等价于上面的lambda表达式的方式。
        // 对于方法引用其实有一种要求的，你所使用的lambda表达式的实现，也就是上面那个lambda表达式的->后面的那个方法体恰好是有一个对应的方法跟他完成相同的功能，这个方法客观存在的话，这种时候就可以使用这种方法引用替换lambda表达式。
        // lambda表达式是一种通用的编码写法，而方法引用是一种满足某种条件才可以使用的一种更简洁的编码方式。
        students.sort(Student::compareStudentByScore);
        students.forEach(item -> System.out.println(item.getScore()));
        System.out.println("=========================================================");
        // 使用lambda对Student进行按照name排序
        students.sort((studentParam1, studentParam2) -> Student.compareStudentByName(studentParam1, studentParam2));
        students.forEach(item -> System.out.println(item.getName()));
        System.out.println("=========================================================");
        students.sort(Student::compareStudentByName);
        students.forEach(item -> System.out.println(item.getName()));
        System.out.println("=========================================================");
        StudentComparator studentComparator = new StudentComparator();
        // 使用第二种方法引用来编码(引用名::实例方法名)
        students.sort(studentComparator::compareStudentByScore);
        students.forEach(item -> System.out.println(item.getScore()));
        System.out.println("=========================================================");
        // 使用第二种方法引用来编码(引用名::实例方法名)
        // students.sort(StudentComparator::compareStudentByName);
        students.forEach(item -> System.out.println(item.getName()));
        System.out.println("========================================================");
        // 下面是第三种方法引用来编码(类名::实例方法名。这种的比较难理解)
        // 那么Comparator的compare方法理论应该接收两个参数，这里自定义的compareByScore只接收一个参数，这不复合规则啊，这是怎么对应上的呢？
        // compareByScore这个实例方法，一定是有那么一个Student对象来调用这个实例方法，这个对象就是sort方法里面所接收的lambda表达式的第一个参数，一定是用sort方法里面所接收的lambda表达式的第一个参数去调用的compareByScore方法。如果接收多个参数的话，那么除了第一个参数之外的后续所有参数都作为后面被调用的compareByScore这个方法的参数传递进去。
        students.sort((studentParam1, studentParam2) -> studentParam1.compareByScore(studentParam2));
        students.sort(Student::compareByScore);
        students.forEach(item -> System.out.println(item.getScore()));
        System.out.println("========================================================");
        students.sort(Student::compareByName);
        students.forEach(item -> System.out.println(item.getName()));
        System.out.println("========================================================");
        List<String> cities = Arrays.asList("qingdao", "chognqing", "tianjin", "beijing");
        Collections.sort(cities, (city1, city2) -> city1.compareToIgnoreCase(city2));
        students.forEach(city -> System.out.println(city));
        System.out.println("========================================================");
        // 第三种方法引用的实现方式
        Collections.sort(cities, String::compareToIgnoreCase);
        students.forEach(city -> System.out.println(city));
        System.out.println("========================================================");
        // 下面是第四种方法引用，构造方法引用
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        // 参数是一个Supplier实例，它是不接收参数，返回一个String对象，和String的不带参数的构造方法一致，所以就会调用String的不带参数的构造方法生成String的一个对象(也就是调用这个函数式接口的实例的get()方法的时候会返回一个空的String对象)
        System.out.println(methodReferenceTest.getString(String::new));
        // 参数是一个Function实例，它接收一个String参数，返回一个String对象，和String的接收一个参数的构造方法吻合，所以调用这个函数式接口的实例的apply方法的时候会调用String接收一个参数的构造方法返回一个String对象
        System.out.println(methodReferenceTest.getString2("hello", String::new));

    }

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String str, Function<String, String> function) {
        return function.apply(str);
    }
}