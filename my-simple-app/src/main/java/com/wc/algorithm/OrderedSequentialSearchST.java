package com.wc.algorithm;

import java.io.IOException;

public class OrderedSequentialSearchST<Key extends Comparable<Key>, Value> {

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
            if (key.compareTo(x.key) == 0) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        if (first == null) {// 一个节点都没有，创建一个节点
            first = new Node(key, value, null);
            return;
        }

        Node preNode = null;
        for (Node x = first; x != null; x = x.next) {
            int cmp = key.compareTo(x.key);
            if (cmp > 0) {
                preNode = x;
                continue;
            }

            if (cmp == 0) {// 命中，覆盖值
                x.value = value;
            } else if (cmp < 0) {
                if (x == first) {// 只有一个节点时
                    first = new Node(key, value, first);
                } else {
                    Node node = new Node(key, value, x);
                    preNode.next = node;
                }
            }
            break;
        }
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
        OrderedSequentialSearchST<String, Integer> st = new OrderedSequentialSearchST<String, Integer>();
        String[] strArray = new String[] { "Z", "X", "B", "C", "D", "B", "A", "X", "X" };
        for (String str : strArray) {
            if (st.get(str) == null) {
                st.put(str, 1);
            } else {
                st.put(str, st.get(str) + 1);
            }
        }
        System.out.println(st.toString());
    }
}
