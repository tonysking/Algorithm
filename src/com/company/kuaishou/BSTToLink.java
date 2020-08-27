package com.company.kuaishou;

/**
 * 二叉搜索树与双向链表
 */
public class BSTToLink {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int v) {
            this.val = v;
        }
    }

    static TreeNode pre;
    static TreeNode head;

    public static TreeNode treeToLink(TreeNode root) {
        inorder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }


    public static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }
        inorder(root.left);
        if(pre == null) {
            head = root;
        } else {
            pre.right = root;
        }
        root.left = pre;
        pre = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);

        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = new TreeNode(1);
        right.right = new TreeNode(5);
        TreeNode link = treeToLink(root);

        TreeNode cur = link;
        while(cur.right != link) {
            System.out.print(cur.val);
            System.out.print("->");
            cur = cur.right;
        }
        System.out.print(cur.val);
        System.out.print("-> head");


    }
}
