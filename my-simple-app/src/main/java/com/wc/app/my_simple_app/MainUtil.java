package com.wc.app.my_simple_app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import javax.swing.JButton;

public class MainUtil {
    static {
        x = 5;
    }
    static int x, y;
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 3, 4);
        int sum = list.stream().map(n -> n * n).reduce((x, y) -> x + y).get();
        System.out.println(sum);
    }

    private static void myFunctionalInterface() {
        excute(new WorkInterface() {
            @Override
            public void doSomething() {
                System.out.println("traditional inner class...do something!");
            }
        });

        excute(() -> System.out.println("functional interface...do something!"));
    }

    public static void lambdaTest() {
        List<String> list = Arrays.asList("Java", "Python", "C", "C++");
        for (String lan : list) {
            System.out.println(lan);
        }

        list.forEach(lan -> System.out.print(lan + " "));
        
        list.forEach(System.out::println);

        System.out.println("\n");

        list.stream().filter((str) -> str.startsWith("C")).forEach(str -> System.out.println(str));

        List<Integer> list1 = Arrays.asList(1, 3, 4, 5, 6, 15, 7, 9);
        evaluate(list1, (n) -> n % 2 == 0);
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        if (list == null) {
            return;
        }
        
        /*for (Integer n : list) {
            if (predicate.test(n)) {
                System.out.println(n);
            }
        }*/
        list.stream().filter(predicate).forEach(n -> System.out.println(n));
    }

    public static void lambdaTest1() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("before java 8, Thread is like this");
            }
        }).start();

        new Thread(() -> System.out.println("In java 8, Thread is like this")).start();
    }

    public static void lambdaTest2() {
        JButton button = new JButton("ok");
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("before java 8, actionListener-->actionPerformed!");
            }
        });
        
        button.addActionListener((e) -> System.out.println("In Java 8, actionListener-->actionPerformed!"));
    }

    public static void excute(WorkInterface w) {
        w.doSomething();
    }

    private static void myMethod() {
        y = x++ + ++x;
        System.out.println(x);
        System.out.println(y);
    }

    private void plusMethod(int i) {
        i++;
    }
}

@FunctionalInterface
interface WorkInterface {
    public abstract void doSomething();
}
