package com.hust.tree;

/**
 * 是否是平衡二叉树
 */
public class IsBalanced {

    public class ReturnType {
        boolean isBalacned;
        int depth;

        public ReturnType(boolean isBalacned, int depth) {
            this.isBalacned = isBalacned;
            this.depth = depth;
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        return processIsBalanced(root).isBalacned;
    }

    public ReturnType processIsBalanced(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        ReturnType left = processIsBalanced(root.left);
        ReturnType right = processIsBalanced(root.right);
        boolean isBalanced = false;
        int depth = Math.max(left.depth, right.depth) + 1;
        if (left.isBalacned && right.isBalacned && Math.abs(left.depth - right.depth) <= 1) {
            isBalanced = true;
        }
        return new ReturnType(isBalanced, depth);
    }

    // ---改进
    public ReturnType processIsBalanced2(TreeNode root) {
        if (root == null) {
            return new ReturnType(true, 0);
        }
        ReturnType left = processIsBalanced(root.left);
        // 一旦不平衡就直接返回false
        if (!left.isBalacned) {
            return new ReturnType(false, 0);
        }
        ReturnType right = processIsBalanced(root.right);
        if (!right.isBalacned) {
            return new ReturnType(false, 0);
        }
        if (Math.abs(left.depth - right.depth) > 1) {
            return new ReturnType(false, 0);
        }
        int depth = Math.max(left.depth, right.depth) + 1;
        return new ReturnType(true, depth);
    }
}
