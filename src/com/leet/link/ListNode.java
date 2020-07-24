package com.leet.link;

public class ListNode {
  int val;
  ListNode next;
  ListNode(int x) {
    val = x;
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

  public void print() {
    ListNode head = this;
    while (head != null) {
      System.out.print(head.val);
      System.out.print("->");
      head = head.next;
    }
    System.out.println("null");
  }
}
