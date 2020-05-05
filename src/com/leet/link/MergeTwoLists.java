package com.leet.link;

public class MergeTwoLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return l2;
      }
      if (l2 == null) {
        return l1;
      }
      ListNode l = new ListNode(-1);
      ListNode head = l;
      while (l1 != null && l2 != null) {
        if (l1.val > l2.val) {
          l.next = l2;
          l2 = l2.next;
        } else {
          l.next = l1;
          l1 = l1.next;
        }
        l = l.next;
      }
      if (l1 != null) {
        l.next = l1;
      }
      if (l2 != null) {
        l.next = l2;
      }
      return head;
  }
}
