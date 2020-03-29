package com.hust.tree;

/**
 * 二叉搜索树与双向链表
 */
public class ConvertToList2 {
    // 一定要明确递归函数的意义, 即该函数返回的是该树的什么，然后根据确定好的函数返回值编写后续逻辑
    // Convert(root)返回以root为根节点的树转换为双向链表后的【头节点】
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = Convert(root.left);
        TreeNode curLeft = left; // 保存左边双向链表的头节点
        // 获得左边双向链表的最后一个节点
        while (left != null && left.right != null) {
            left = left.right;
        }
        root.left = left;
        if (left != null) {
            left.right = root;
        }

        TreeNode right = Convert(root.right);
        // 调整后继节点
        root.right = right;
        if (right != null) {
            right.left = root;
        }
        return curLeft != null ? curLeft : root;

    }

//    // 返回转换为双向链表后的【尾节点】
//    public TreeNode Convert2(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
//        TreeNode right = Convert(root.right);
//        TreeNode curright = right;
//        while (right != null && right.left != null) {
//            right = right.left;
//        }
//        // 调整后继节点
//        root.right = right;
//        if (right != null) {
//            right.left = root;
//        }
//        TreeNode left = Convert(root.left); // 得到的即为最右节点
//        root.left = left;
//        if (left != null) {
//            left.right = root;
//        }
//        return curright != null ? curright : root;
//    }

    public static void main(String[] args) {
        ConvertToList2 convertToList = new ConvertToList2();
        TreeNode head = convertToList.Convert(TreeNode.getTree());
        while (head.right != null) {
            System.out.print(head.val);
            head = head.right;
        }


//        TreeNode last = convertToList.Convert2(TreeNode.getTree());
//        while (last.left != null) {
//            System.out.println(last.val);
//            last = last.left;
//        }
    }
}
