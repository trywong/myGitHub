package com.test.jdk8.stream;

import java.util.Arrays;
import java.util.List;

public class StreamTest3 {
    public static void main(String[] args) {
        // 需求：有一个整形类型的集合，我要将这个list里面的每一个整数让他它乘以2，然后将乘以2以后的集合里面的所有的数字加在一起得到一起求和的结果
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 7, 8);
        // 先得到list对应的流，然后要对里面的每一个元素乘以2，相当于把流里面的每个元素都转换成另外一个值(可能转换成类型相同的，也可能转换成类型不同的)，对于这样的操作在流里面用的是map()。
        // 源是这个list，中间操作是map()，map()本身又返回一个Stream，reduce操作就是终止操作(及早求值)，reduce表示的是用0+流里面的第一个元素*2+流里面的第二个元素*2...以此类推
        System.out.println(list.stream().map(i -> 2 * i).reduce(0, Integer::sum));
    }
}
