package com.leet.link;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 23. 合并K个排序链表
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        // 注意边界条件
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for(ListNode node : lists) {
            // 注意边界条件
            if (node != null) {
                queue.offer(node);
            }
        }

        ListNode pre = new ListNode(-1);
        ListNode head = pre;

        while(!queue.isEmpty()) {
            ListNode cur = queue.poll();
            head.next = cur;
            head = head.next;
            if(cur.next != null) {
                queue.offer(cur.next);
            }
        }
        return pre.next;
    }
}
