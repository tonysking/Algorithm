package com.hust.tree;

/**
 * not online
 * 最大搜索二叉子树
 */
public class MaxBST {
    public TreeNode getMaxBST(TreeNode root) {
        return processBST(root).maxBSTRoot;
    }

    private ReturnType processBST(TreeNode root) {
        if (root == null) {
            return new ReturnType(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ReturnType left = processBST(root.left);
        ReturnType right = processBST(root.right);
        // 最大BST在左右子树中
        TreeNode maxBSTRoot = null;
        int maxBSTSize = 0;
        int max = Math.max(root.val, Math.max(left.max, right.max));
        int min = Math.max(root.val, Math.min(left.max, right.max));
        if (left.maxBSTSize > right.maxBSTSize) {

            maxBSTRoot =  left.maxBSTRoot;
            maxBSTSize = left.maxBSTSize;
        } else {
            maxBSTRoot =  right.maxBSTRoot;
            maxBSTSize = right.maxBSTSize;
        }

        // 若当前节点能与左右子树形成BST
        if (root.val > left.max && root.val < right.min
                && root.left == left.maxBSTRoot && root.right == right.maxBSTRoot) {
            maxBSTRoot = root;
            maxBSTSize = left.maxBSTSize + 1 + right.maxBSTSize;
        }

        return new ReturnType(maxBSTRoot, maxBSTSize, max, min);

    }

    public class ReturnType {
        public TreeNode maxBSTRoot;
        public int maxBSTSize;
        public int max;
        public int min;

        public ReturnType(TreeNode maxBSTRoot, int maxBSTSize, int max, int min) {
            this.maxBSTRoot = maxBSTRoot;
            this.maxBSTSize = maxBSTSize;
            this.max = max;
            this.min = min;
        }
    }
    
}
