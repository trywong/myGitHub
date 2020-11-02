package com.wc.thingking_in_java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyPractice {
    static void testSet() {
        Set<String> set = new HashSet<String>();
        String str1 = "This is a string";
        String str2 = new String("This is a string");
        String str3 = new StringBuffer("This is a string").toString();
        set.add(str1);
        set.add(str2);
        set.add(str3);
        System.out.println(set.size());
        System.out.println(set);

        System.getProperties().list(System.out);
    }

    private static void extream() {
        float fMax = Float.MAX_VALUE;
        float fMin = Float.MIN_VALUE;
        double dMax = Double.MAX_VALUE;
        double dMin = Double.MIN_VALUE;
        System.out.println(fMax);
        System.out.println(fMin);
        System.out.println(dMax);
        System.out.println(dMin);
    }

    int x = 99;

    public void print(int param) {
        System.out.println(param + 1);
    }

    /*public static void main(String[] args) {
        TestClass[] array = new TestClass[10];
        array[0] = new TestClass("hahaha");
    }*/
    
    public static void main(String...strings) throws Exception {
        Integer a = 1;
        a = null;
        int b = testNPE(a);
    }

    public static int testNPE(Integer i) {
        return i;
    }

    /**
     * 统计一个字符在字符串中的所有位置
     * @param str
     * @param ch
     * @return
     * @Throws 异常信息
     * @History 2017年2月14日 下午2:57:42 by wangchuan
     */
    private static int[] countPosition(String str, char ch) {
        int[] position = {};
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (ch == charArray[i]) {
                position = Arrays.copyOf(position, position.length + 1);
                position[position.length - 1] = i;
            }
        }
        return position;
    }
}

class TestClass {
    static int y = 57;

    TestClass() {
    }

    TestClass(int x) {
        // this();
        this(x, "123");
    }
    
    TestClass(String str) {
        System.out.println(str);
    }

    TestClass(int x, String str) {
    }

    protected void finalize() {
        System.out.println("回收……");
    }
}

class Cups {
    static String cup1;
    static String cup2;
    static {
        cup2 = "cup2";
    }

    Cups() {
        System.out.println("Cups()");
    }

    public static void print() {
        System.out.println(cup1 + "," + cup2);
    }
}
