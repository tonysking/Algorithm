package com.leet.link;

/**
 * 143. 重排链表
 */
public class ReorderList {
    ListNode ohead;
    ListNode first;
    boolean isEnd;
    public void reorderList(ListNode head) {
        ohead = head;
        isEnd = false;
        first = head;
        reorder(head);
//        ohead.print();
    }

    public void reorder(ListNode last) {
        if(last != null) {
            reorder(last.next);
            System.out.println("------------------");
            System.out.println("first:" + first.val);
            System.out.println("last:" + last.val);
            if(!isEnd) {
                if(first != last && first.next != last) {
                    ohead.print();
                    ListNode next = first.next;
                    first.next = last;
                    last.next = next;
                    first = next;
                } else {
                    System.out.println("first<" + first.val + ">相遇last<" + last.val + ">");
                    last.next = null;
                    isEnd = true;
                }
            }

        }
    }

    public static void main(String[] args) {
        ReorderList res = new ReorderList();
        res.reorderList(ListNode.createListByArray(new int[]{1, 2, 3, 4}));
    }
}
