package com.test.jdk8.methodreference;

public class Student {

    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    // 根据score排序两个Student（排序方法）
    public static int compareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    // 根据名字进行比较
    // 这两个方法在设计上其实是有问题的，这两个方法的实现里面没有使用任何这个类里面的东西，也就是说这两个方法不放在这个类里放在任意一个别的类里都是可以正常使用的。正确的做法应该是对调用这个方法的那个对象和通过参数传递给这个方法的对象进行比较(当然这就需要构建这个类的实例然后通过实例调用这个方法)，而不是说需要比较的两个对象都通过参数传递
    public static int compareStudentByName(Student student1, Student student2) {
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    // 比较正确的定义比较方法是按照下面这两种方式进行定义，要使用当前的student里面的属性和传递进来的student里面的属性进行比较，而不是说要比较的两个对象都通过参数传递
    public int compareByScore(Student student) {
        return this.getScore() - student.getScore();
    }

    public int compareByName(Student student) {
        return this.getName().compareToIgnoreCase(student.getName());
    }
}
