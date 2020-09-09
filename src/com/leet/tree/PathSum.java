package com.leet.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. 路径总和 II
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> lPath = new ArrayList<>();
        if (root == null) {
            return res;
        }
        pathSummer(root, lPath, res, 0, sum);
        dfs(root, sum, new ArrayList<>());
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

    List<List<Integer>> res2 = new ArrayList<>();
    public void dfs(TreeNode root, int sum, List<Integer> path) {
        if(root == null) {
            return;
        }
        path.add(root.val);
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null) {
            res2.add(new ArrayList<>(path));
        }

        dfs(root.left, sum, path);
        dfs(root.right, sum, path);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        PathSum res = new PathSum();
        res.pathSum(TreeNode.getTree(), 7);
    }
}
