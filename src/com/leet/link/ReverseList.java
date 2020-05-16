package com.leet.link;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preHead = head;

        // 头插法，pre一直不变
        ListNode pre = head;
        head = head.next;

        ListNode next;

        while (head != null) {
            next = head.next;

            head.next = preHead;
            pre.next = next;

            preHead = head;
            head = next;

        }
        return preHead;
    }


    // 递归头插
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseListRecursive(head, head, head.next);
    }

    public ListNode reverseListRecursive(ListNode head, ListNode pre, ListNode cur) {
        if (cur == null) {
            return head;
        }

        ListNode next = cur.next;

        cur.next = head;
        pre.next = next;

        return reverseListRecursive(cur, pre, next);

    }

    // 递归简化
    public ListNode reverseList3(ListNode head) {
        return reverseListRecursiveEasy(null, head);
    }

    public ListNode reverseListRecursiveEasy(ListNode head, ListNode cur) {
        if (cur == null) {
            return head;
        }
        ListNode next = cur.next;

        cur.next = head;

        return reverseListRecursiveEasy(cur, next);

    }
}
