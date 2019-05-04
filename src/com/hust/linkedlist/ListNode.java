package com.hust.linkedlist;

/**
 * 单链表
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode getList() {
        ListNode head = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        head.next = p2; p2.next = p3; p3.next = p4; p4.next = p5; p5.next = p6;
        return head;
    }

    // 通过数组创建链表
    public static ListNode createListByArray(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode pre = head;
        for (int i = 1; i < a.length; i++) {
            pre.next = new ListNode(a[i]);
            pre = pre.next;
        }
        return head;
    }

}
