package com.leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 */
public class IntervalMerging {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0 || intervals[0].length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = res.get(res.size() - 1);
            // 当前区间和上一个区间重合
            if(intervals[i][0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
