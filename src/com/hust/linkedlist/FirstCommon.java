package com.hust.linkedlist;

/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommon {
    //---用两个指针扫描”两个链表“，最终两个指针到达 null 或者到达公共结点。
    /*
     思想：
        将两个链表L1和L2进行拼接，得到L1+L2和L2+L1两个拼接结果,
     这两个拼接后的链表长度是一致的，逐个判断即可

        虽然两个链表可能不一样长,但是当短的链表走到末尾之后又回到长的链表的头那里,
     长的链表走到末尾又回到短的头那里,这样两者就一样长了,然后第二次肯定会在公共节点相遇

        note:有公共节点的话后面的部分都是一样的  只是前面的长度不同而已
     eg:   1-3-5-7
              /
             2
        p1:1-3-5-7-n-2  -5-7-n
        p2:2-5-7-n-1-3  -5-7-n
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1!=p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;


    }

    // 记录长度差遍历法
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        int n = 0; // 记录长度差
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1.next != null) { // ---要获得最后一个节点，所以判断p1.next
           p1 = p1.next;
           n++;
        }
        while (p2.next != null) {
            p2 = p2.next;
            n--;
        }
        if (p1 != p2) {
            return null;
        }

        p1 = n > 0? pHead1 : pHead2; // p1指向较长的链表
        p2 = p1 == pHead1? pHead2 : pHead1;
        while (n-- != 0) { // p1先走n步
            p1 = p1.next;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
