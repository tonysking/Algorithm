package com.hust.tree;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class MirrorTree {
    public void Mirror(TreeNode root) {
        if (root != null) {
            // 注意必须交换root.left 直接交换引用left和right是无效的
            /*TreeNode left = root.left;
            TreeNode right = root.right;*/
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            Mirror(root.left);
            Mirror(root.right);

        }
    }
}
