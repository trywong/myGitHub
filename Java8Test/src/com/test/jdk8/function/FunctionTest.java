package com.test.jdk8.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world");
        // Lambda构建
        list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        // 下面通过方法引用构建lambda表达式函数式接口的实例来改造上面的代码【方法引用构建】
        list.stream().map(String::toUpperCase).forEach(item -> System.out.println(item));
        // 我们看一下toUpperCase方法源码会发现，它本身是不接收任何参数的，返回类型是String类型的。
        // 那Function<String,String>后面那个泛型类型String可以对上了，对应返回的String类型。那前面那个类型是怎么对应呢？这个其实是四种方法引用中的一种，toUpperCase方法是一个实例方法，一定是通过String的一个字符串对象来调用这个方法，
        // 这个语法两个:前面那个String指示的是一个类，后面的toUpperCase相当于用String这个类的类型直接引用了它的一个实例方法。
        // 对于这种结构 类型::一个实例方法
        // ，这种，它的第一个输入参数一定就是调用这个实例方法的那个对象，也就是说这个toUpperCase方法被调用的时候，一定会存在一个字符串String类型的对象，然后由这个对象去调用toUpperCase方法，那Function<String,String>泛型里面的第一个参数String
        // 参数指的就是这个String对象喽，和这个对应上喽。这里的第一个输入参数就是循环的当前元素item(一个String对象)，是用这个对象去调用后面的toUpperCase方法的。
        // 如果是通过一个类，后面两个冒号，跟着一个实例方法的都是这种的，前面一个类，后面一个实例方法，表示的是引用这个类的一个实例的这个方法，它所对应的第一个参数一定都是调用后面那个实例方法的一个对象，换句话说后面那个实例方法被调用的时候一定会存在一个前面那个类型的一个对象，调用真正这个对象的那个方法。
        // Function函数式接口表示的是一种动作，里面的T只是申明一种对象类型，一种类型，R表示的是处理完之后返回结果的类型，执行的的逻辑是说，一定是有一个T类型的对象去执行apply方法里面的动作之后，返回一个R类型的结果。

        Function<String, String> function = String::toUpperCase;

        System.out.println("============================================");
        FunctionTest test = new FunctionTest();
        // 第一个参数是1，第二个参数传递的是一个行为
        // statement

        // Function函数式接口表示的是一种动作，里面的T只是申明一种对象类型，一种类型，R表示的是处理完之后返回结果的类型，执行的的逻辑是说，一定是有一个T类型的对象去执行apply方法里面的动作之后，返回一个R类型的结果。如下这个示例里面的“value
        // -> {return 2 *
        // value}”这个其实只是定义一个行为动作，是定义一个apply方法里面的逻辑动作，相当于是对函数式接口的apply方法的一个实现，这个动作真正执行的地方是把这个动作传递到哪里去了，在那里执行apply方法的时候就是执行这个动作了(因为一个接口类型指向的对象里面的方法被调用，肯定是会有一个这个接口的实现类的实例，是调用这个实例的这个方法。那这里的这个实例就是用lambda表达式生成的那个函数式接口的实例)。这里compute方法被调用的时候第二个参数传递的是行为。
        // 下面compute()方法里面执行的apply()方法的时候实际就是执行的调用这个方法的地方传递进来的动作，实际执行的就是“value -> {return 2 *
        // value}));”这个动作，“value -> {return 2 * value}));”这个说白了就是针对apply方法的实现，是函数式接口Function接口的一个实现。
        System.out.println(test.compute(1, value -> {
            return 2 * value;
        }));
        // 第一个参数是2，第二个参数传递的是一个行为
        // expression
        System.out.println(test.compute(2, value -> 5 + value));
        System.out.println(test.compute(3, value -> value * value));
        System.out.println(test.convert(5, value -> String.valueOf(value + "helloworld")));

        // 也可以先定义Lambda表达式，再传递进去
        Function<Integer, Integer> function2 = value -> value * 2;

        System.out.println(test.compute(4, function2));
    }

    // 这里的a是一个参数，方法里面的apply这个动作本身也是在使用者使用这个方法的时候进行传递的，这叫传递行为
    // 你直接看代码通过这个方法定义你根本不知道function.apply(a);这个要对a执行什么样的行为，行为是调用端在调用的时候传进来的。
    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }

    // 输入参数a是一个整形，function是一个行为，返回的结果是一个字符串
    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }
}
