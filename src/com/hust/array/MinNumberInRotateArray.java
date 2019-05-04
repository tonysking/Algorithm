package com.hust.array;

/**
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个 非减排序 的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid = 0;
        while (low <= high) {

            if (array[low] < array[high]) { // ---每次都要判断 当有序时直接返回array[low]
                return array[low];
            }

            mid = low + ((high - low) >> 1);
            if (array[low] > array[mid]) { // 一定在low...mid内
                high = mid;
                continue;
            }
            if (array[mid] > array[high]) { // 一定在mid+1...high内
                low = mid + 1;
                continue;
            }

            int min = array[low]; // 非以上三种情况只可能array[low]==array[mid]==array[high]
            for (int i = low; i < high; i++) { // 直接遍历寻找最小值 ---亦可继续优化
                if (array[i] < min) {
                    min = array[i];
                }
            }
            return min;

        }
        return array[low];
    }


    public static void main(String[] args) {
        MinNumberInRotateArray m = new MinNumberInRotateArray();
        int[] a1 = {4,5,1,2,3};
        int[] a = {4,5,6,7,4,4,4};
        int minNum = m.minNumberInRotateArray(a);
        System.out.println(minNum);

    }
}
