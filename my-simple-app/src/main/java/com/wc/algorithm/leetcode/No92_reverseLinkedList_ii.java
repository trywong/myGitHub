package com.wc.algorithm.leetcode;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 *
 * @author wangchuan
 * @date 2020-12-07 17:09
 * @since 1.0.0
 */
public class No92_reverseLinkedList_ii {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        // 以下两指针用户反转
        ListNode pre = null;
        ListNode cur = head;
        while (m > 1) {
            pre = cur;
            cur = cur.next;
            m--;
            n--;
        }
        ListNode firstPart = pre;
        ListNode secondPart = cur;

        // 反转
        while (n > 0) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            n--;
        }

        // 不是从最开始反转，将第一部分与反转后的链头连接
        if (firstPart != null) {
            firstPart.next = pre;
        }
        // 从最开始反转的，直接将反转后的链头作为head
        else {
            head = pre;
        }
        secondPart.next = cur;
        return head;
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

        No92_reverseLinkedList_ii no92 = new No92_reverseLinkedList_ii();
        ListNode reverseList = no92.reverseBetween(node1, 2, 5);
        System.out.println(ListNode.toString(reverseList));
    }
}
