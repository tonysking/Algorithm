package com.hust.tree;

import com.hust.linkedlist.DoubleNode;

/**
 * 二叉搜索树与双向链表
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertToList {

    public class ReturnType {
        TreeNode first; // 保存头节点
        TreeNode end;   // 保存尾节点

        public ReturnType(TreeNode first, TreeNode end) {
            this.first = first;
            this.end = end;
        }
    }
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return null;
        }
        return process(root).first;
    }

    // 后序遍历
    private ReturnType process(TreeNode root) {
        if (root == null) {
            return new ReturnType(null, null);
        }
        ReturnType leftList = process(root.left);
        ReturnType rightList = process(root.right);
        // 修改root指针
        root.left = leftList.end;
        root.right = rightList.first;
        // 修改左右链表指针
        if (leftList.end != null) {

            leftList.end.right = root;
        }
        if (rightList.first != null) {

            rightList.first.left = root;
        }
        return new ReturnType(leftList.first != null? leftList.first : root,
                        rightList.end != null ? rightList.end : root);
    }

    public static void main(String[] args) {
        ConvertToList convertToList = new ConvertToList();
        TreeNode head = convertToList.Convert(TreeNode.getTree());
        while (head.right != null) {
            System.out.print(head.val);
            head = head.right;
        }
    }
}
