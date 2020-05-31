package com.leet.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static TreeNode getTree() {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return root;
    }

    public static TreeNode getTree(int[] a) {
        TreeNode root = new TreeNode(a[0]);
        TreeNode n2 = new TreeNode(a[1]);
        TreeNode n3 = new TreeNode(a[2]);
        TreeNode n4 = new TreeNode(a[3]);
        TreeNode n5 = new TreeNode(a[4]);
        TreeNode n6 = new TreeNode(a[5]);
        TreeNode n7 = new TreeNode(a[6]);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return root;
    }
}
