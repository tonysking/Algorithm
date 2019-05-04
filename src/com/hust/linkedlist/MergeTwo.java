package com.hust.linkedlist;

/**
 * 合并两个有序链表
 */
public class MergeTwo {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //临界条件
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return  l1;
        }

        ListNode l3 = null;
        if (l1.val<l2.val){
            l3 = l1;
            l1 = l1.next;
        } else {
            l3 = l2;
            l2 = l2.next;
        }
        ListNode pre = l3;
        while (l1!=null && l2!=null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            } else if (l1.val > l2.val) {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            } else {
                //---相等时 不去重
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
//                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }
        return l3;
    }
}
