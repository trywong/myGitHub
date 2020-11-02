package com.test.jdk8.supplier;

import java.util.function.Supplier;

import com.test.jdk8.bean.Student;

public class StudentTest {
    public static void main(String[] args) {
        Supplier<Student> supplier = () -> new Student();
        System.out.println(supplier.get().getName());

        // 通过构造方法引用创建函数式接口的实例()
        // 这行代码的意思就是调用Student的构造方法。最终的结果就是返回一个Supplier对象。为什么这里能返回一个Supplier对象呢，因为Supplier的函数式方法是不接参数，返回一个Student对象，而对于Student构造方法来说，也是不接收参数，返回一个Student
        // 对象，这是复合Supplier的契约的要求。所以这种定义方式是OK的
        Supplier<Student> supplier2 = Student::new;
        System.out.println(supplier2.get().getName());

        // 如果在Student里面不仅提供不带参数的构造方法，再继续提供带参数的构造方法Student(String name, Integer age){}的话会怎么样呢？
        // 执行结果是一样的，因为编译器在编译上述构造方法引用的时候它知道左边是一个Supplier的声明，右边是要求不接收参数，同时返回一个Student对象
        // 所以，它就去Student里面去找，找不带参数的并且返回一个Student的构造方法。
        // 再做修改，如果把Student里面的不带参数的构造方法删掉，那上面那个构造方法引用创建函数式接口的编写方式就会报错了
        // Supplier的契约就是不接收参数，同时返回一个结果，这就是Supplier的全部。
    }
}
