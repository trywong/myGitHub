package com.wc.thingking_in_java;

import com.wc.Main;

/**
 * @author shovel
 * @date 2018/10/24 17:34
 * @since 1.0.0
 */
public class A {
    public void test(A obj) {
        System.out.println("A and A");
    }

    public void test(D obj) {
        System.out.println("A and D");
    }
}

class B extends A {
    @Override
    public void test(A obj) {
        System.out.println("B and A");
    }

    public void test(B obj) {
        System.out.println("B and B");
    }
}

class C extends B {

}

class D extends B {

}

class TestClazz {
    public static void main(String[] args) {
        A aa = new A();
        A ab = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        aa.test(b);
        aa.test(c);
        aa.test(d);

        ab.test(b);
        ab.test(c);
        ab.test(d);
    }
}
