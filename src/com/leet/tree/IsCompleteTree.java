package com.leet.tree;

public class IsCompleteTree {
    private int size = 0;
    private int maxIndex = 0;
    public boolean isCompleteTree(TreeNode root) {
        preOrder(root, 1);
        return size == maxIndex;
    }

    private void preOrder(TreeNode root, int index) {
        if(root == null) {
            return;
        }
        size++;
        maxIndex = Math.max(maxIndex, index);
        preOrder(root.left, index * 2);
        preOrder(root.right, index * 2 + 1);
    }

    public static void main(String[] args) {
        IsCompleteTree res = new IsCompleteTree();
        boolean completeTree = res.isCompleteTree(TreeNode.getTree());
        System.out.println(completeTree);
    }
}
