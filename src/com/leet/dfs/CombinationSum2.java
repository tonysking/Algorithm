package com.leet.dfs;

import java.util.*;

/**
 * 40. 组合总和 II
 */
public class CombinationSum2 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        getCombination(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void getCombination(int[] candidates, int target, int index,
                               List<Integer> curList) {
        if(target == 0) {
            res.add(new ArrayList<>(curList));
            return;
        }
        if(target < 0 || index == candidates.length) {
            return;
        }

        // 选
        curList.add(candidates[index]);
        getCombination(candidates, target - candidates[index], index + 1, curList);
        curList.remove(curList.size() - 1);

        // 不选
        // 跳过所有 和 当前数相同的数
        while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) {
            index++;
        }
        getCombination(candidates, target, index + 1, curList);
    }

    public static void main(String[] args) {
        CombinationSum2 res = new CombinationSum2();
        List<List<Integer>> lists = res.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        System.out.println(lists);
    }
}
