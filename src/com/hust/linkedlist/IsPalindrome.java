package com.hust.linkedlist;

import java.util.Stack;

public class IsPalindrome {
    public boolean isPalindrome(ListNode pHead) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = pHead;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (pHead != null) {
            if (pHead.val != stack.pop().val) {
                return false;
            }
            pHead = pHead.next;
        }
        return true;
    }

}
