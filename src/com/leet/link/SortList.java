package com.leet.link;

/**
 * 148. 排序链表
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMidNode(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode head = new ListNode(-1);
        if(l1.val < l2.val) {
            head.next = l1;
            l1.next = mergeList(l1.next, l2);
        } else {
            head.next = l2;
            l2.next = mergeList(l2.next, l1);
        }
        return head.next;
    }

    private ListNode getMidNode(ListNode head) {
        ListNode preMid = head;
        ListNode mid = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            preMid = mid;
            mid = mid.next;
        }
        preMid.next = null;
        return mid;
    }

    public static void main(String[] args) {
        SortList res = new SortList();
        ListNode sortList = res.sortList(ListNode.createListByArray(new int[]{4, 2, 1, 3}));
        sortList.print();
    }
}
