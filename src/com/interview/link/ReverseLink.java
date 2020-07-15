package com.interview.link;

import static com.hust.sort.Code_04_QuickSort.swap;

/**
 * jd
 */
public class ReverseLink {
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode next = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverse2(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode p = head;
        ListNode next;
        p = p.next;
        while (p != null) {
            next = p.next;
            pre.next = p;
            p.next = head;
            head = p;
            p = next;
        }
        return pre.next;
    }


    public void quickSort(int[] a, int l, int r) {
        int q = partion(a, l, r);
        quickSort(a, l, q - 1);
        quickSort(a, q + 1, r);
    }

    private int partion(int[] a, int l, int r) {
        int num = a[r];
        int less = l - 1;
        int more = r;
        int cur = l;
        while (less < more) {
            if (a[cur] <= num) {
                swap(a, ++less, cur);
                cur++;
            } else {
                swap(a, --more, cur);
            }
        }
        return less;
    }
    // T(N) = 2T(N/2) + O(N)
}
