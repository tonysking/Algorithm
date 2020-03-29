package com.hust.DP;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法
 */
public class RectCover {
    public int RectCover(int target) {
        if (target < 1) {
            return 0;
        }
        return cover(target);
    }

    //--- 注意f(n)的定义 由n可直接决定f的输出，因此推导的是f(n)和f(n-1)...之间的关系，
    //                                      不要在参数中考虑放置位置的细节
    private int cover(int n) {
        if (n == 1|| n == 2) { // 覆盖前两列
            return n;
        }
        return cover(n-2)  // 最后两行覆盖--- 注意是一样的效果 并非两种情况
                + cover(n-1); // 最后一列覆盖

    }

    public static void main(String[] args) {
        RectCover rectCover = new RectCover();
        int methods = rectCover.RectCover(3);
        System.out.println(methods);
    }


}
