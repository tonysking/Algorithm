package com.hust.linkedlist;

import java.util.HashMap;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {
    // 按 无序链表 写的方法
    public ListNode deleteDuplication(ListNode pHead) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 删除重复节点  保留1个
        ListNode pre = null;
        ListNode cur = pHead;
        while (cur != null) {
            if (map.containsKey(cur.val)) {
                pre.next = cur.next;
                map.put(cur.val, 2);
            } else {
                map.put(cur.val, 1);
                pre = cur; // 只有当前节点非重复节点才更新pre
            }
            cur = cur.next;
        }

        /*// 删除出现过重复的所有节点
        pre = null;
        cur = pHead;
        while (cur != null) {
            if (map.get(cur.val) == 2) {
                if (pre != null) {
                    pre.next = cur.next;
                }else { // 第一个节点即重复节点，将头指针后移
                    pHead = cur.next;
                }

            } else {

                pre = cur;
            }
            cur = cur.next;
        }*/
        return pHead;
    }
}
