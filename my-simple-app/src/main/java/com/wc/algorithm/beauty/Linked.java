package com.wc.algorithm.beauty;

/**
 * @author shovel
 * @date 2018/11/29 11:11
 * @since 1.0.0
 */
public class Linked {

    public static void main(String[] args) {
        Linked lru = new Linked();
        /*Node head = lru.getNode(20);

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.item + "-");
            temp = temp.next;
        }*/

        Node head = lru.getNode();
        boolean bool = lru.isPalindrome1(head);

        System.out.println("bool = " + bool);

        /*while (head != null) {
            System.out.print(head.item + "-");
            head = head.next;
        }*/
    }

    Node getNode() {
        Node head  = new Node(1);
        Node p2 = new Node(2);
        Node p3 = new Node(3);
        Node p4 = new Node(4);
        Node p5 = new Node(5);
        Node p6 = new Node(4);
        Node p7 = new Node(3);
        Node p8 = new Node(2);
        Node p9 = new Node(1);

        head.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;
        p7.next = p8;
        p8.next = p9;
        return head;
    }

    Node getNode(int n) {
        Node head  = new Node(0);
        Node pNode = head;
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            pNode.next = node;
            pNode = node;
        }

        return head;
    }

    /**
     * 最近最常使用策略
     * 思路：将最近使用的，放到链表头
     * @param head
     * @param element
     * @return
     */
    Node LRU(Node head, int element) {
        if (head == null) {
            head = new Node(element);
            return head;
        }

        Node pre = null;
        Node pNode = head;
        while (pNode != null) {
            if (pNode.item == element) {
                // 只有pNode一个结点，不做处理
                if (pNode.next == null) {
                    return head;
                }

                // 删除pNode
                pre.next = pNode.next;

                // 将pNode放到链表头
                pNode.next = head;
                head = pNode;
                break;
            } else {
                // 只有pNode一个结点
                if (pNode.next == null) {
                    Node node = new Node(element);
                    node.next = pNode;
                    head = node;
                } else {
                    pre = pNode;
                    pNode = pNode.next;
                }
            }
        }
        return head;
    }

    /**
     * 反转链表
     * 思路：以头结点为支点，将后续结点放到head位置
     * @param head
     */
    Node reverseLinked(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node pNode = head;
        while (pNode!= null && pNode.next != null) {
            // 删除pNode下一结点
            Node node = pNode.next;
            pNode.next = pNode.next.next;

            // 将删除结点放到头结点
            node.next = head;
            head = node;
        }

        return head;
    }

    /**
     * 链表反转递归实现
     * @param head
     * @return
     */
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = this.reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public boolean isPalindrome(Node head) {
        // 遍历链表，得出长度
        int len = 0;
        Node p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        // 将前半部分反转
        int mid = len / 2;
        p = head;
        for (int i = 0; i < mid - 1; i++) {
            Node t = p.next;
            p.next = p.next.next;
            t.next = head;
            head = t;
        }

        Node p1 = null;
        // 如果len为偶数，p的下一结点为第二指针位置
        // 如果len为奇数，p的下下个结点为第二指针位置
        if (len % 2 == 0) {
            p1 = p.next;
        } else {
            p1 = p.next.next;
        }

        // 恢复p指针到head位置
        p = head;

        // 两个指针同时后移，对比值
        while (p1 != null) {
            if (p.item != p1.item) {
                return false;
            }

            p = p.next;
            p1 = p1.next;
        }

        return true;
    }

    public boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 将slow后的链表反转
        slow = this.reverse(slow.next);

        while (slow != null) {
            if (head.item != slow.item) {
                return false;
            }

            head = head.next;
            slow = slow.next;
        }

        return true;
    }

    private class Node {
        int item;
        Node next;

        public int getItem() {
            return item;
        }

        public void setItem(int item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node(int item) {
            this.item = item;
        }
    }
}
