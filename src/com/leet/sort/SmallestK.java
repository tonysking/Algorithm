package com.leet.sort;

import java.util.PriorityQueue;

/**
 * 面试题 17.14. 最小K个数
 */
public class SmallestK {
    public int[] smallestK(int[] arr, int k) {
        if(k == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> (b - a));
        for(int num : arr) {
            if(heap.size() < k) {
                heap.offer(num);
            } else {
                if(heap.peek() > num) {
                    heap.poll();
                    heap.offer(num);
                }
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        SmallestK res = new SmallestK();
        int[] smallestK = res.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
        for (int i = 0; i < smallestK.length; i++) {
            System.out.print(smallestK[i] + " ");
        }
    }
}
