package com.leet.stack;

public class LargestRectangleArea {
    /*
        暴力：高不变，扩展寻找最大底
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int area = getMaxArea(i, heights);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int getMaxArea(int i, int[] heights) {
        int height = heights[i];
        int maxLength = 1;
        int left = i - 1;
        int right = i + 1;
        while (left >= 0 && heights[left] >= height) {
            maxLength++;
            left--;
        }
        while (right < heights.length && heights[right] >= height) {
            maxLength++;
            right++;
        }
        return height * maxLength;
    }


}
