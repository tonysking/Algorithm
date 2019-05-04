package com.hust.linkedlist;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Reverse {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode next = null;
        ListNode cur = head.next;
        //头插
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            head.next = next;
            cur = next;
        }
        return pre;
    }

    // 标准
    public ListNode ReverseList2(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
