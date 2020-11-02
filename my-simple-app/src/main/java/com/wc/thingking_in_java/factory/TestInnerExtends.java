package com.wc.thingking_in_java.factory;

import com.wc.thingking_in_java.innerclass.IPlant;
import com.wc.thingking_in_java.innerclass.Tree;
import com.wc.thingking_in_java.testextends.InnerClassExtends;

public class TestInnerExtends extends InnerClassExtends {
    public IPlant innerExtends() {
        return new InnerClassExtends.InnerExtends();
    }

    public IPlant showPlant(final int i) {
        return new IPlant() {

            @Override
            public void grow() {
                System.out.println(i);
            }
        };
    }

    public Tree showTree(final String name) {
        return new Tree(name) {
            private String str;
            @Override
            public void grow() {
                str = name;
                System.out.println(str);
            }
        };
    }
}
