package com.hust.tree;

import java.util.Stack;

/**
 * 是否是二叉搜索树
 */
public class IsBST {
    public boolean isValidBST(TreeNode root) {
        return processIsBST(root).isBST;
    }
    public class ReturnType {
        boolean isBST;
        int min;
        int max;

        public ReturnType(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public ReturnType processIsBST(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        ReturnType left = processIsBST(root.left);
        if (!left.isBST) {
            return new ReturnType(false, 0, 0);
        }
        ReturnType right = processIsBST(root.right);
        if (!right.isBST) {
            return new ReturnType(false, 0, 0);
        }
        if (left.max >= root.val || root.val >= right.min) {
            return new ReturnType(false, 0, 0);
        }
        int min = Math.min(root.val, Math.min(left.min, right.min));
        int max = Math.max(root.val, Math.max(left.max, right.max));
        return new ReturnType(true, min, max);
    }

    // ---法2 中序遍历看是否递增
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if (pre != null && root.val <= pre.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
}
