package com.hust.linkedlist;

/**
 * 链表分割
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前 *
 * 给定一个链表的头指针 ListNode* Head，请返回重新排列后的链表的头指针。
 * 注意：分割以后保持原来的数据顺序不变
 */
public class Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode sH = null; // 小于头
        ListNode sT = null; //   --尾
        ListNode eH = null; // 大于等于头
        ListNode eT = null; //   --尾
        // 将原链表所有节点依次划分进 小于、大于等于 两个个链表
        while (head != null) {
            if (head.val < x) {
                if (sH == null) { // sH指向第一个小于x的节点
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            }
            head = head.next;
        }
        // 令两个链表的尾部之后为null, 否则以下的连接过程会导致无限循环
        if (sT != null) sT.next = null;
        if (eT != null) eT.next = null;
        // 连接链表
        if (sT != null) { // 存在小于部分
            sT.next = eH;
            return sH;
        } else { // 不存在小于部分
            return eH;
        }
    }
    // --优化代码
    public ListNode partition2(ListNode head, int x) {
        ListNode headTest = head; // 测试原链表用
        // ---初始化时对链表头尾赋值
        ListNode sH = new ListNode(-1); // 小于头
        ListNode sT = sH; //   --尾
        ListNode bH = new ListNode(-1); // 大于等于头
        ListNode bT = bH; //   --尾
        while (head != null) {
            if (head.val < x) {
                sT.next = head;
                sT = sT.next;
            } else {
                bT.next = head;
                bT = bT.next;
            }
            head = head.next;
        }
//        ListNode.printListNode(sH.next); // 2-1-n
//        ListNode.printListNode(bH.next); // 5-3-4-6-1-n
//        ListNode.printListNode(headTest);
        sT.next = bH.next; // 2-1-5-3-4-6-1
        bT.next = null; // 若不置为null,则可能成为循环链表
        return sH.next;

    }

    //  分割为小于、等于、大于三部分
    public ListNode partition3(ListNode head, int x) {
        ListNode sH = null; // 小于头
        ListNode sT = null; //   --尾
        ListNode eH = null; // 等于头
        ListNode eT = null; //   --尾
        ListNode bH = null; // 大于头
        ListNode bT = null; //   --尾
        // 将原链表所有节点依次划分进 小于、等于、大于 三个链表
        while (head != null) {
            if (head.val < x) {
                if (sH == null) { // sH指向第一个小于x的节点
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == x) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = head.next;
        }
        // 令三个链表的尾部之后为null, 否则以下的连接过程会导致无限循环
        if (sT != null) sT.next = null;
        if (eT != null) eT.next = null;
        if (bT != null) bT.next = null;
        // 连接链表
        if (sT != null) { // 存在小于部分

            if (eT != null) { // 存在等于部分
                sT.next = eH;
                eT.next = bH;
                return sH;
            } else {
                sT.next = bH;
                return sH;
            }
        } else { // 不存在小于部分
            if (eT != null) { // 存在等于部分
                eT.next = bH;
                return eH;
            } else {
                return bH;
            }
        }
    }

}
