package com.leet.link;

/**
 * 83. 删除排序链表中的重复元素
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        while(head != null) {
            while(head != null && head.next!= null && head.val == head.next.val) {
                head = head.next;
            }
            pre.next = head;

            pre = head;
            head = head.next;

        }
        return preHead.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates res = new DeleteDuplicates();
        ListNode deleteDuplicates = res.deleteDuplicates(ListNode.createListByArray(new int[]{1,1,2}));
        deleteDuplicates.print();
    }
}
