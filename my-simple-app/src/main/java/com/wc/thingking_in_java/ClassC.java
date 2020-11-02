package com.wc.thingking_in_java;

public class ClassC extends ClassA {
    private ClassB classB;

    /*public ClassC(int i) {
        // super();
        System.out.println("classC Constructor" + i);
    }*/

    public ClassB getClassB() {
        return classB;
    }

    public void setClassB(ClassB classB) {
        this.classB = classB;
    }
}
