package com.hust.linkedlist;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 链表中环的入口结点
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode cur = pHead;
        ListNode start = null;
        while (cur != null) {

            hashSet.add(cur);
            if (hashSet.contains(cur.next)) {
                start = cur.next;
                break;
            }
            cur = cur.next;
        }
        return start;

    }

    // 优化空间
    public ListNode EntryNodeOfLoop2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        // ---循环条件是slow != fast, 所以初始赋值非head
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) { // ---注意判断
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
