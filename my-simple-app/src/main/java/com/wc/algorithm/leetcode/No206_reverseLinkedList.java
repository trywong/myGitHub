package com.wc.algorithm.leetcode;

/**
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 *
 * @author wangchuan
 * @date 2020-12-06 18:03
 * @since 1.0.0
 */
public class No206_reverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        // 反转后链头
        ListNode pre = null;
        while (current != null) {
            // 临时记住原链表
            ListNode tmpHead = current.next;

            // 反转
            current.next = pre;
            pre = current;

            current = tmpHead;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(ListNode.toString(node1));

        No206_reverseLinkedList no206 = new No206_reverseLinkedList();
        ListNode reverseList = no206.reverseList(node1);
        System.out.println(ListNode.toString(reverseList));
    }
}
