package com.leet.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 28. 对称的二叉树
 */
public class MirrorTree {
    List<Integer> leftPre;
    List<Integer> rightPost;
    public boolean isMirrorTree(TreeNode root) {
        if(root == null) {
            return false;
        }
        leftPre = new ArrayList<>();
        rightPost = new ArrayList<>();
        preOrder(root.left);
        postOrder(root.right);
        for (int i = 0; i < leftPre.size(); i++) {
            if(leftPre.get(i) != rightPost.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void preOrder(TreeNode root) {
        if(root != null) {
            leftPre.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        } else {
            leftPre.add(-1);
        }
    }

    private void postOrder(TreeNode root) {
        if(root != null) {
            rightPost.add(root.val);
            postOrder(root.right);
            postOrder(root.left);
        } else {
            rightPost.add(-1);
        }
    }

    public static void main(String[] args) {
        MirrorTree res = new MirrorTree();
        TreeNode root = new TreeNode(1);
        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(2);
        root.left = left1;
        root.right = right1;
        left1.left = new TreeNode(3);
        right1.right = new TreeNode(1);
        boolean isMirrorTree = res.isMirrorTree(root);
        System.out.println(isMirrorTree);
    }
}
