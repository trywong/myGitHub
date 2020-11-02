package com.wc.lamda;

import java.util.Arrays;

public class LamdaTest {

    public static void main(String[] args) {
        Man men[] = new Man[] { new Man("Ted", "Neward", 41), new Man("Charlotte", "Neward", 41), new Man("Michael", "Neward", 19),
                new Man("Matthew", "Neward", 13) };
        // sort by firstName
        Arrays.sort(men, (lhs, rhs) -> lhs.firstName.compareTo(rhs.firstName));
        for (Man man : men) {
            System.out.println(man);
        }
    }

    public static Runnable traditionalThread() {
        Runnable runner = new Runnable() {
            public void run() {
                System.out.println("traditional runner");
            };
        };

        return runner;
    }

    public static Runnable newerThread() {
        Runnable runner = () -> System.out.println("newer runner");;
        return runner;
    }
}
