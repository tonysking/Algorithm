package com.leet.sort;

import org.junit.Assert;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 215. 数组中的第K个最大元素
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - 1 - k];
    }

    // 手动堆
    public int findKthLargestHeap(int[] nums, int k) {
        int n = nums.length;
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        // 排序k - 1次
        for (int i = n - 1; i >= n - k + 1 ; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, --heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] a, int heapSize) {
        for (int i = 0; i < heapSize; i++) {
            heapInsert(a, i);
        }
    }

    private void heapInsert(int[] a, int i) {
        int parent = (i - 1) / 2;
        if (a[i] > a[parent]) {
            swap(a, i, parent);
            heapInsert(a, parent);
        }
    }

    private void maxHeapify(int[] a, int i, int heapSize) {
        int largest = i;
        int l = i * 2 + 1;
        int r = l + 1;
        // 从孩子节点更新最大值
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        // 若最大值非当前节点(父节点)，交换后继续向下调整
        if (i != largest) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        a[i] = a[i] ^ a[j];
        a[j] = a[i] ^ a[j];
        a[i] = a[i] ^ a[j];
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        FindKthLargest res = new FindKthLargest();
        Assert.assertEquals(res.findKthLargestHeap(nums, 2), 5);
    }
}
