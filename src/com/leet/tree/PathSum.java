package com.leet.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lPath = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathSummer(root, lPath, res, 0, sum);
        return res;
    }

    private void pathSummer(TreeNode root, List<Integer> lPath, List<List<Integer>> res,
                            int curSum, int sum) {
        if (root == null) {
            return;
        }
        lPath.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null && curSum == sum) {
            // 注
            res.add(new ArrayList<>(lPath));
        }
        pathSummer(root.left, lPath, res, curSum, sum);
        pathSummer(root.right, lPath, res, curSum, sum);
        // 注
        lPath.remove(lPath.size() - 1);
    }
}
