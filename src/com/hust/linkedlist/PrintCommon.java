package com.hust.linkedlist;

/**
 * 打印两个有序链表的公共部分
 */
public class PrintCommon {
    public void printCommonPart(ListNode head1, ListNode head2) {
        System.out.println("链表公共部分：");
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.println(head1.val+" ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}


