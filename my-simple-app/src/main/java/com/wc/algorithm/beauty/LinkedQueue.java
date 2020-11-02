package com.wc.algorithm.beauty;

/**
 * 链表实现队列----链式队列
 * @author shovel
 * @date 2018/11/26 16:42
 * @since 1.0.0
 */
public class LinkedQueue {
    Node head = null;
    Node tail = null;

    public void enqueue(String item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }

        String item = head.item;
        head = head.next;
        // 元素全部出队列，清空
        if (head == null) {
            tail = null;
        }
        return item;
    }

    private class Node {
        private String item;
        private Node next;

        public Node(String item) {
            this.item = item;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        queue.enqueue("e");
        queue.enqueue("f");

        for (int i = 0; i < 8; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
