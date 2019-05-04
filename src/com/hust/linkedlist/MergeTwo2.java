package com.hust.linkedlist;

public class MergeTwo2 {
    public ListNode Merge(ListNode l1, ListNode l2) {
        //临界
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }

        //确立头
        ListNode head = l1.val < l2.val ? l1 : l2;
        //cur1为较小头链表 cur2为较大头链表
        ListNode cur1 = head == l1 ? l1 : l2;
        ListNode cur2 = head == l1 ? l2 : l1;
        ListNode pre = null;
        ListNode next = null;

        //合并
        while (cur1!=null && cur2!=null) {
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                //将cur2插入pre和cur1中
                next = cur2.next;   //保持插入之前的cur2的下一个节点
                cur2.next = cur1;
                pre.next = cur2;
                pre = cur2;
                cur2 = next;   //cur2后移
            }
        }

        //合并剩余
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
