package com.hust.window;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 *
 * 有一个整型数组arr和一个大小为w的窗口从数组的最左边滑到最右边，窗口每次向右边滑一个位置。
 * 　　　　例如，数组为[4, 3, 5, 4, 3, 3, 6, 7]，窗口大小为3时
 *        [4 3 5] 4 3 3 6 7 窗口中最大值为5
 * 　　　　4[3 5 4] 3 3 6 7 窗口中最大值为5
 * 　　　　4 3[5 4 3] 3 6 7 窗口中最大值为5
 * 　　　　4 3 5[4 3 3] 6 7 窗口中最大值为4
 * 　　　　4 3 5 4[3 3 6] 7 窗口中最大值为6
 * 　　　　4 3 5 4 3[3 6 7] 窗口中最大值为7
 * 　　　　如果数组长度为n，窗口大小为w，则一共产生n - w + 1个窗口的最大值。
 * 　　　　请实现一个函数。
 * 　　　　输入：整型数组arr，窗口大小为w。
 * 　　　　输出：一个长度为n - w + 1的数组res，res[i]表示每一种窗口状态下的最大值。
 * 　　　　以本题为例，结果应该返回{ 5,5,5,4,6,7 }。
 */
public class GetWindowMax {
  public static int[] getMaxWindow(int[] arr,int w) {
    if(arr == null || w < 1 || w > arr.length) {
      return null;
    }
    // 结果数组
    int[] maxRes = new int[arr.length - w + 1];
    int index = 0;
    // 窗口中最大值队列
    Deque<Integer> deque = new LinkedList<>();
    for (int i = 0; i < arr.length; i++) {
      // 维护一个从大到小的双端队列
      // 尾部入队
      while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
        deque.pollLast();
      }
      deque.addLast(i);
      // 队首最大值有效判定: 下标是否在窗口范围内, 不在则出队
      if (deque.peekFirst() == i - w) {
        deque.pollFirst();
      }
      // 从窗口边界w-1开始，每向右移动一次，记录当前窗口的最大值
      if (i >= w - 1) {
        maxRes[index++] = arr[deque.peekFirst()];
      }
    }
    return maxRes;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
    int[] maxWindow = getMaxWindow(arr, 3);
    for(int max : maxWindow) {
      System.out.print(max + " ");
    }
  }
}
