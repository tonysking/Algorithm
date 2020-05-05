package com.leet.link;

public class AddTwoNumbers {
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode l = new ListNode(0);
      ListNode head = l;
      boolean flag = false;
      while (l1 != null && l2 != null) {
        int val = l1.val + l2.val;
        if (flag) val++;
        if (val > 9) {
          l.next = new ListNode(val % 10);
          flag = true;
        } else {
          l.next = new ListNode(val);
          flag = false;
        }
        l1 = l1.next;
        l2 = l2.next;
        l = l.next;
      }
      if (l1 != null) {
        l.next = l1;

      }
      if (l2 != null) {
        l.next = l2;
      }

      while (l.next != null) {
        if (flag) {
          l.next.val++;
          if (l.next.val > 9) {
            l.next.val %= 10;
            flag = true;
          } else {
            flag = false;
          }
        }
        l = l.next;
      }

      if (flag) {
        l.val %= 10;
        l.next = new ListNode(1);
        return head.next;
      }

      return head.next;
  }

  public static void main(String[] args) {
    ListNode l1 = ListNode.createListByArray(new int[]{3,7});
    ListNode l2 = ListNode.createListByArray(new int[]{9,2});
    ListNode l = addTwoNumbers(l1, l2);
    while (l != null) {
      System.out.println(l.val);
      l = l.next;
    }
  }
}
