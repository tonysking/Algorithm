package com.hust.linkedlist;

/**
 * 环形单链表约瑟夫问题
 */
public class Joseph {
    public static ListNode getResult(ListNode head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        // ---求处环形单链表的前置节点 注意不是null m=1时直接删head节点
        ListNode pre = head;
        while (pre.next != head) {
            pre = pre.next;
        }

        int count = 0;
        while (head != pre) {
            if (++count == m) { // ++count不是count++，否则从0开始报数
                pre.next = head.next;
                count = 0;

            } else {
                pre = head;
            }
            head = head.next;
        }
        return head;
    }

    // 自写--直接给出最后一个人的编号
    public static int getResult(int n, int m) {
        if (n <= 1 || m < 1) {
            return 1;
        }
        int count = 0;
        boolean[] isKill = new boolean[n];
        int cur = 0;
        int num = n; // n个人
        while (n!=1) {
            if (++count == m) {
                count = 0;
                isKill[cur%num] = true;
                n--;
            }
            while (isKill[(cur+1) % num] == true) {
                cur = (cur+1) % num;
            }
            cur = (cur+1) % num;
        }
        return cur+1;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l1;
        ListNode result = Joseph.getResult(l1, 1);
        System.out.println(result.val);

        System.out.println(Joseph.getResult(385,248)); // 300


    }
}
