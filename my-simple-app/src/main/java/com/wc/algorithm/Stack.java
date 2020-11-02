package com.wc.algorithm;

/**
 * 链表实现栈
 * @author wangchuan 
 */
public class Stack<T> {
    Node first;
    int N;
    
    private class Node {
        private T item;
        private Node next;
        public Node(T item) {
            this.item = item;
        }
    }
    
    public void push(T item) {
        Node oldFirst = first;
        first = new Node(item);
        first.next = oldFirst;
        N++;
    }
    
    public T pop() {
        T item = first.item;
        first = first.next;
        N--;
        return item;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
}
