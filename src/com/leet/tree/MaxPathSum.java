package com.leet.tree;

/**
 * 124. 二叉树中的最大路径和
 */
public class MaxPathSum {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathSumNode(root);
        return maxSum;
    }

    public NodePath maxPathSumNode(TreeNode root) {
        if (root == null) {
            return new NodePath(0, true);
        }
        NodePath left = maxPathSumNode(root.left);
        NodePath right = maxPathSumNode(root.right);
        // 注意节点为null的特殊处理
        /*int subMax = Math.max(left.max, right.max);
        if (left.isNull) {
            subMax = right.max;
        }
        if (right.isNull) {
            subMax = left.max;
        }
        if (left.isNull && right.isNull) {
            subMax = 0;
        }*/
        // 优化：只有在最大贡献值大于 0 时，才会选取对应子节点(不需要isNull判断)
        int subMax = Math.max(Math.max(left.max, right.max), 0);
        // 注：NodePath节点中保存的最大路径max必须是包含当前根节点的max,且左右孩子只能选一个
        int max = Math.max(subMax + root.val, root.val);
        maxSum = Math.max(maxSum, max);
        // 最终的最大路径则可能包含两个孩子
        maxSum = Math.max(maxSum, root.val + left.max + right.max);
        return new NodePath(max, false);
    }

    private static class NodePath {
        int max;
        boolean isNull;
        NodePath(int max, boolean isNull) {
            this.max = max;
            this.isNull = isNull;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);

        MaxPathSum res = new MaxPathSum();
        int sum = res.maxPathSum(root);
        System.out.println(sum);
    }
}
