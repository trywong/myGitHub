package com.wc.algorithm;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static String toString(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pointer = head;
        StringBuilder sb = new StringBuilder(pointer.val + "");
        while (pointer != null) {
            pointer = pointer.next;
            if (pointer == null) {
                sb.append("->NULL");
            } else {
                sb.append("->" + pointer.val);
            }
        }
        return sb.toString();
    }
}