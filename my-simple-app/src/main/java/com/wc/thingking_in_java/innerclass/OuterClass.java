package com.wc.thingking_in_java.innerclass;

public class OuterClass {
    private String outerStr;

    public class InnerClass {
        void innerMethod() {
            System.out.println("innerMethod()");
        }

        public InnerClass() {
            System.out.println("inner Constructor: " + outerStr);
        }
    }

    InnerClass getInnerClass() {
        outerStr = "outer string";
        return new InnerClass();
    }

    public static void main(String[] args) {
        OuterClass.InnerClass inner = new OuterClass().getInnerClass();
        inner.innerMethod();

        OuterClass.InnerClass in = new OuterClass().new InnerClass();
    }
}
