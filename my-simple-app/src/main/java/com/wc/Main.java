package com.wc;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        /*List<Apple> apples = new ArrayList<>();
        apples.add(new Apple());
        apples.add(new GreenApple());

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit());
        fruits.add(new Apple());

        upMethod(apples);
        // downMethod(apples);编译报错

        upMethod(fruits);
        downMethod(fruits);*/

        /*Instant instant = Instant.ofEpochMilli(System.currentTimeMillis());
        instant.plus(Duration.ofHours(2));
        System.out.println(instant);*/

        System.out.println("aaa");
        System.out.println("bbb");
        System.out.println("ccc");
        System.out.println("ddd");
    }

    /**
     * 上界通配符
     */
    public static void upMethod(List<? extends Fruit> list){
        //编译报错
        //使用通配符后,不能在往集合类中添加元素
        //list.add();

        //使用通配符后,是可以取出元素的
        //所有取出的元素,都是上界父类元素
        Fruit fruit = list.get(0);
    }


    /**
     * 下界通配符
     */
    public static void downMethod(List<? super Fruit> list){
        //下界通配符可以往容器内添加元素
        //但是有限制,必须是Fruit的子类或者本身,父类是添加不进去的
        list.add(new Apple());

        //取出元素的类型都为Object
        Object object = list.get(0);
    }

    private static void xxx() {
        List<Buss> bussList = new ArrayList<>();
        bussList.add(new Buss("a", 10, 0.3));
        bussList.add(new Buss("b", 3, 0.8));
        bussList.add(new Buss("c", 5, 2.0));
        bussList.add(new Buss("b", 30, 3.2));
        bussList.add(new Buss("c", 20, 0.1));

        List<Buss> st = new ArrayList<>();
        bussList.stream().collect(Collectors.groupingBy(Buss::getName)) // 分组(Name can't be null)
                .forEach((k, v) -> {
                    Optional<Buss> sum = v.stream().reduce((v1, v2) -> {  // 合并
                        v1.setCount(v1.getCount() + v2.getCount());
                        v1.setValue(v1.getValue() + v2.getValue());
                        return v1;
                    });
                    st.add(sum.orElse(new Buss("other", 0, 0.0)));

                });
        System.out.println(st);

        bussList.stream().forEach(System.out::println);
    }

    private static void threadTest() {
        long start = System.currentTimeMillis();
        System.out.println("实时信息111");

        new Thread(() -> {
            Main main = new Main();
            try {
                main.scheduleTest();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("实时信息222");
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }

    public void scheduleTest() throws InterruptedException {
        ScheduledExecutorService scheduExec = Executors.newScheduledThreadPool(1);
        scheduExec.schedule(() -> {
            System.out.println("延迟加载信息");
        }, 5 * 1000, TimeUnit.MILLISECONDS);

        // Thread.sleep(5 * 1000);

        scheduExec.shutdown();
        while (!scheduExec.isTerminated()) {
        }
    }
}

class Fruit{}
class Apple extends Fruit{}
class GreenApple extends Apple{}