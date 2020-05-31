package com.leet.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 101. 对称二叉树
 * 左右子树：同时遍历，反向遍历
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSym(root, root);
    }

    public boolean isSym(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (q != null && p != null && p.val == q.val) {
            return isSym(p.left, q.right) && isSym(p.right, q.left);
        }
        return false;
    }


    // 中序：失败 如 [1,2,2,2,null,2]
    public boolean isSymmetric2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> leftStack = new Stack<>();
        boolean isLeft = true;
        TreeNode r = root;
        stack.push(root);
        while (!stack.isEmpty() && root != null) {
            if (root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                // print root
                root = stack.pop();
                System.out.println(root.val);

                // 左子树节点如栈
                if (isLeft) {
                    if (root != r) {
                        leftStack.push(root.val);
                    } else {
                        isLeft = false;
                    }
                } else {
                // 右子树节点比较
                    if (leftStack.isEmpty() || leftStack.pop() != root.val) {
                        return false;
                    }
                }
                if (root.right != null) {
                    stack.push(root.right);
                    root = root.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsSymmetric res = new IsSymmetric();
        int[] a = new int[]{1, 2, 2, 3, 4, 4, 3};
        TreeNode tree = TreeNode.getTree(a);
        boolean symmetric = res.isSymmetric2(tree);
        System.out.println(symmetric);
    }
}
