package com.hust.tree;

/**
 * not online
 * 二叉树节点间最大距离
 */
public class MaxDistancce {
    public class ReturnType {
        int depth;
        int max;

        public ReturnType(int depth, int max) {
            this.depth = depth;
            this.max = max;
        }
    }
    public int getMaxDistance(TreeNode root) {
        return processMaxDis(root).max;
    }

    private ReturnType processMaxDis(TreeNode root) {
        if (root == null) {
            return new ReturnType(0,0);
        }
        ReturnType left = processMaxDis(root.left);
        ReturnType right = processMaxDis(root.right);
        int depth = Math.max(left.depth, right.depth) + 1;
        int max = left.depth + right.depth + 1;
        max = Math.max(max, Math.max(left.max, right.max));
        return new ReturnType(depth, max);

    }
}
