package com.wc.effectivejava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsClassifier {
    public static String classifier(Set<?> set) {
        return "set";
    }
    public static String classifier(List<?> list) {
        return "list";
    }
    public static String classifier(Collection<?> set) {
        return "unknown";
    }
    
    public static void main(String[] args) {
        Collection<?>[] array = new Collection<?>[] {
            new HashSet<String>(),
            new ArrayList<Integer>(),
            new HashMap<String, Double>().values()
        };
        
        for (Collection<?> c : array) {
            System.out.println(classifier(c));
        }
        /*System.out.println(classifier(new HashSet<String>()));
        System.out.println(classifier(new ArrayList<Integer>()));
        System.out.println(classifier(new HashMap<String, Double>().values()));*/
    }
}
