package com.leet.link;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode pre = preHead;
        ListNode cur = head;
        ListNode fast = head;
        while(n > 0 && fast != null) {
            fast = fast.next;
            n--;
        }
        if(fast == null) {
            pre.next = cur.next;
            return pre.next;
        }
        while(fast != null) {
            pre = cur;
            cur = cur.next;
            fast = fast.next;
        }
        pre.next = cur.next;
        return preHead.next;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd res = new RemoveNthFromEnd();
        ListNode listNode = res.removeNthFromEnd(ListNode.createListByArray(new int[]{1, 2, 3, 4, 5}), 2);
        listNode.print();
        ListNode listNode1 = res.removeNthFromEnd(ListNode.createListByArray(new int[]{1}), 1);
        listNode1.print();
    }
}
