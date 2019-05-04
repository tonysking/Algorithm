package com.hust.tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversal {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                // 节点不为空 则 将其左孩子节点全部入栈
                if (root != null) { // ---注意是root!=null不是root.left
                    stack.push(root);
                    root = root.left;
                } else {
                // 节点为空 则出栈 进入右孩子节点
                    root = stack.pop();
                    arrayList.add(root.val);
                    root = root.right;
                }
            }
        }
        return arrayList;
    }
}
