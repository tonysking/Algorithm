package com.hust.tree;

public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode getTree(){
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        root.left = n2; root.right = n3;
        n2.left = n4; n2.right = n5;
        n3.left = n6; n3.right = n7;
        return root;
    }

}
