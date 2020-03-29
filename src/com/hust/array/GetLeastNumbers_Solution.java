package com.hust.array;

import java.util.ArrayList;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */
public class GetLeastNumbers_Solution {
    //大根堆，时间复杂度O(nlogk)
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k < 1 || k > input.length) {
            return arrayList;
        }

        int[] kHeap = new int[k];
        // 构建有 k 个数的大根堆
        for (int i = 0; i < k; i++) {
            heapInsert(kHeap, input[i], i);
        }
        // 从k开始遍历完整个数组，维护大根堆
        for (int i = k; i < input.length; i++) {
            if (input[i] < kHeap[0]) { // 当前数比堆顶小则替换堆顶，然后调整堆
                kHeap[0] = input[i];
                heapify(kHeap, 0, k);
            }
        }

        // 结果放入arrayList
        for (int i = 0; i < k; i++) {
            arrayList.add(kHeap[i]);
        }
        return arrayList;

    }

    // 将value插入大根堆arr中， 初始下标为index，之后[从下往上]调整堆
    private void heapInsert(int[] arr, int value, int index) {
        arr[index] = value;
        while (index != 0) { // index为0时调整至堆顶，结束
            int parent = (index - 1) >>> 1;
            if (arr[index] > arr[parent]) { // 若 下标index的节点大于父节点 则交换
                swap(arr, parent, index);
                index = parent;
            } else {
                break;
            }
        }
    }

    // 在大根堆arr中[从上到下]调整下标为index的节点
    private void heapify(int[] arr, int index, int heapSize) {
        int half = heapSize >>> 1;
        while (index < half) { // index小于堆大小的一半时，获取其孩子节点，从上到下调整堆(或left<heapSize))
            int left = (index << 1) + 1;
            int right = left + 1;
            int largest = left; // 初始最大为左孩子
            if (right < heapSize && arr[right] > arr[largest]) { // ---注意判断right<heapSize，否则会越界
                largest = right;
            }
            if (arr[index] < arr[largest]) { // 父节点小于孩子节点最大值
                swap(arr, index, largest);
                index = largest;
            } else {
                break;
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution solution = new GetLeastNumbers_Solution();
        int[] input = {4,5,1,6,2,7,3,8};
        int[] input2 = {4,5,1,6,2,7,2,8};
        ArrayList<Integer> arrayList = solution.GetLeastNumbers_Solution(input2, 2);
        System.out.println(arrayList);
    }
}
