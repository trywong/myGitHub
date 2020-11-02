package com.wc.effectivejava;

import java.util.ArrayList;
import java.util.List;

public class MyClass implements IMyInterface {

    @Override
    public Object getSomeObject() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getSomeString() {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {
        /*Object[] array = new Long[1];
        array[0] = "hahahah";
        
        List<String> list = new ArrayList<String>();
        list.toArray(new String[]{});*/
        
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        String[] desc = new String[5];
        String[] array = list.toArray(desc);
        System.out.println(array.length);
    }
}
