package com.hust.array;

/**
 * 二维数组中的查找
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInSortedArray {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int col = array[0].length;
        // 从右上角开始寻找
        int r = 0;
        int c = col - 1;
        while (r < row && c > -1) {
            if (array[r][c] == target) {
                return true;
            } else if (array[r][c] < target) { // 小于则向下一行移动
                r++;
            } else { // 大于则向左一列移动
                c--;
            }
        }
        return false;
    }
}
