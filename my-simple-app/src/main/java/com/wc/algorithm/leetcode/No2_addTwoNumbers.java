package com.wc.algorithm.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 */
public class No2_addTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        return doAddTwoNumbers(l1, l2, 0);
    }

    public ListNode doAddTwoNumbers(ListNode l1, ListNode l2, int add2Next) {
        // 链表位数相同
        if (l1 == null && l2 == null) {
            if (add2Next != 0) {
                return new ListNode(add2Next);
            }
            return null;
        }
        if (l1 == null) {
            l1 = new ListNode(0);
        }
        if (l2 == null) {
            l2 = new ListNode(0);
        }

        int tmpSum = l1.val + l2.val + add2Next;
        // 进位
        add2Next = tmpSum / 10;
        // 当前位数字
        int tmpNum = tmpSum % 10;
        ListNode head = new ListNode(tmpNum);
        head.next = doAddTwoNumbers(l1.next, l2.next, add2Next);
        return head;
    }
}


