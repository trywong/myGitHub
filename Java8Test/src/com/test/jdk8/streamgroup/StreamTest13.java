package com.test.jdk8.streamgroup;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {
    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // 需求，对这些学生按照名字进行分组，按照流的方式进行实现
        // 此时可以看到collect方法返回的是一个Map<String, List<Student>类型的结果
        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map);

        // 下面是根据分数进行分组
        // 此时可以看到collect方法返回的是一个Map<Integer, List<Student>类型的结果
        Map<Integer, List<Student>> map2 = students.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(map2);

        // 需求，实现按照name进行分组，并且获得名字以及这个名字的学生的个数，相当于实现如下sql达到的效果：
        // select name,count(*) from student group by name;
        // 此时再看collect方法返回的结果是一个Map<String, Long>类型的结果
        // 注释里对Collectors.counting()的解释：返回的是一个Collector，接收T类型的参数，这个会计算出输入元素的个数，如果没有元素存在结果就是0
        Map<String, Long> map3 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(map3);

        // 按照name进行分组，每组里面再求所有学生的平均值
        Map<String, Double> map4 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(map4);
        System.out.println("====================================================");

        // 以上讲解的是分组，下面讲解分区
        // 分数90以及90以上的算通过，其余的算不通过
        Map<Boolean, List<Student>> map5 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
        System.out.println(map5);
    }
}
