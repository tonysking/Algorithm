package com.hust.tree;

public class TreeToSequence {
    public String toSequence(TreeNode root) {
        if (root == null) {
            return "";
        }
        String res;
        String left = toSequence(root.left);
        String right = toSequence(root.right);
        res = "("+left+right+")";
        return res;
    }
}
