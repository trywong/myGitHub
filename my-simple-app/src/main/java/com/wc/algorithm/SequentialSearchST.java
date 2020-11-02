package com.wc.algorithm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 顺序查找，基于无序（单）链表
 * @author wangchuan
 * @since
 */
public class SequentialSearchST<Key, Value> {

    private Node first;

    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public String toString() {
            return "[key:" + key + ";value:" + value + "]";
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;// 查找命中
            }
        }
        return null; // 查找未命中
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;// 覆盖值
                return;
            }
        }

        // 创建一个新节点在首位
        first = new Node(key, value, first);
    }

    public void delete(Key key) {
        Node preNode = null;// 上一个节点key
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(first.key)) {// 第一个节点
                first = x.next;
                continue;
            }

            if (key.equals(x.key)) {// 找到待删除节点
                preNode.next = x.next;
                continue;
            }
            preNode = x;
        }
    }

    public final int size() {
        int size = 0;
        for (Node x = first; x != null; x = x.next) {
            size++;
        }
        return size;
    }

    public Set<Key> keys() {
        Set<Key> set = new HashSet<Key>();
        for (Node x = first; x != null; x = x.next) {
            set.add(x.key);
        }
        return set;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Node x = first; x != null; x = x.next) {
            sb.append(x.toString() + "\n");
        }
        return sb.toString();
    }

    /**
     * 基于无序链表的顺序查询
     * @author wangchuan
     * @since
     */
    public static void main(String[] args) throws IOException {
        // 单词出现次数统计
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("E:/rename.js")));
        String reg1 = "\\s+";
        String reg2 = "\\w+";
        Pattern p = Pattern.compile(reg2);
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] strArray = line.split(reg1);
            for (String str : strArray) {
                if (!p.matcher(str).matches()) {
                    continue;
                }
                if (st.get(str) == null) {
                    st.put(str, 1);
                } else {
                    st.put(str, st.get(str) + 1);
                }
            }
        }
        System.out.println(st.size());
        st.delete("else");
        st.delete("match");
        st.delete("ffffff");
        System.out.println(st.size());
        System.out.println(st.keys());

        String max = " ";
        st.put(max, 0);

        for (String key : st.keys()) {
            if (st.get(key) > st.get(max)) {
                // st.put(max, st.get(key));
                max = key;
            }
        }
        System.out.println("max:" + max);
        System.out.println("max count:" + st.get(max));
    }
}
