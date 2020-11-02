package com.test.jdk8.lambda;

@FunctionalInterface
interface MyInterface {
    // 这个方法是要子类来实现的
    void test();

    String toString();

}

public class Test2 {
    public void myTest(MyInterface myInterface) {
        System.out.println(1);
        myInterface.test();
        System.out.println(2);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        /*test2.myTest(new MyInterface() {
            @Override
            public void test() {
                System.out.println("mytest");
            }
        });*/
        // 括号里面的就相当于是MyInterface的一个实现
        test2.myTest(() -> {
            System.out.println("mytest");
        });
        MyInterface myInterface = () -> {
            System.out.println("mytest");
        };
        System.out.println(myInterface.getClass());
        System.out.println(myInterface.getClass().getSuperclass());
        System.out.println(myInterface.getClass().getInterfaces()[0]);
    }
}
