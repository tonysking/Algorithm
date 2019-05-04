package com.hust.linkedlist;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintFromTail {
    private ArrayList<Integer> arrayList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return arrayList;
        }

        ArrayList<Integer> arrayList = printListFromTailToHead(listNode.next);
        arrayList.add(listNode.val);
        return arrayList;

    }
}
