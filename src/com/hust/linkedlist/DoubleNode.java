package com.hust.linkedlist;

/**
 * 双向链表
 */
public class DoubleNode {
    public int val;
    public DoubleNode last;
    public DoubleNode next;
    public DoubleNode(int val) {
        this.val = val;
    }

    // 正反打印双向链表
    public static void printDoubleNode(DoubleNode head) {
        System.out.print("双向链表：");
        DoubleNode end = null;
        while (head != null) {
            System.out.print(head.val+"->");
            end = head;
            head = head.next;
        }
        System.out.print("| ");
        while (end != null) {
            System.out.print(end.val+"->");
            end = end.last;
        }
        System.out.println("null");
    }

    // 反转双向链表
    public static DoubleNode reverseList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next; // 比单链表反转多了前置节点
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        DoubleNode head = new DoubleNode(1);
        DoubleNode d2 = new DoubleNode(2);
        DoubleNode d3 = new DoubleNode(3);
        head.last = null; head.next = d2;
        d2.last = head; d2.next = d3;
        d3.last = d2; d3.next = null;

        DoubleNode.printDoubleNode(head);
        DoubleNode reverseList = DoubleNode.reverseList(head);
        DoubleNode.printDoubleNode(reverseList);
    }
}
