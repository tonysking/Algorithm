package com.hust.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * not online
 * 是否是完全二叉树(Complete Binary Tree)
 */
public class IsCBT {
    public boolean isCBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean shouldLeaf = false;
        while (!queue.isEmpty()) {
            root = queue.poll();
            TreeNode left = root.left;
            TreeNode right = root.right;
            // 只有右子树没有左子树
            if (left == null && right!= null || shouldLeaf && (left != null || right != null)){
                return false;
            }
            if (left != null) {
                queue.offer(left);
            }
            if (right != null) {
                queue.offer(right);
            } else { // 右子树为空 之后的都应该是叶子节点
                shouldLeaf = true;
            }
        }
        return true;
    }
}
