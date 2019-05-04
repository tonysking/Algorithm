package com.hust.linkedlist;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 */
public class KthToTail {
    public ListNode FindKthToTail(ListNode head,int k) {
        //边界
        if (head == null || k < 1) {
            return null;
        }

        ListNode first = head;
        ListNode last = head;
        while (k>0 && last!=null) {
            last = last.next;
            k--;
        }
        if (last == null){
            // 刚好是第一个
            if (k == 0) {
                return first;
            }
            // 没有倒数第k个
            return null;
        }

        while (last != null) {
            first = first.next;
            last = last.next;
        }
        return  first;
    }
}
