package com.leet.link;

/**
 * 25. K 个一组翻转链表
 */
public class ReverseKGroup {
    ListNode nextHead;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode pre = preHead;
        ListNode curHead = head;
        while(curHead != null) {
            ListNode newTail = curHead;

            if(!notKNodes(curHead, k)) {
                pre.next = curHead;
                break;
            }
            // 翻转后首位相连
            pre.next = reverse(curHead, k);
            newTail.next = nextHead;
            // 更新前置和当前节点
            pre = newTail;
            curHead = nextHead;
        }
        return preHead.next;
    }

    private ListNode reverse(ListNode head, int k) {
        ListNode pre = null;
        ListNode next;
        while(head != null && k > 0) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            nextHead = next;
            k--;
        }
        return pre;
    }

    private boolean notKNodes(ListNode head, int k) {
        while (k-- > 0) {
            if(head == null) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ReverseKGroup res = new ReverseKGroup();
        ListNode node = res.reverseKGroup(ListNode.createListByArray(new int[]{1, 2, 3, 4, 5}), 3);
        node.print();
    }
}
