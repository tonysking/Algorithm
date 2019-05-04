package com.hust.tree;

import java.util.ArrayList;
import java.util.Stack;

public class PostorderTraversal {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(root);
            while (!stack1.isEmpty()) {
                root = stack1.pop();
                stack2.push(root); // stack1为中右左 放入stack2中为左右中
                if (root.left != null) {
                    stack1.push(root.left);
                }
                if (root.right != null) {
                    stack1.push(root.right);
                }
            }
            while (!stack2.isEmpty()) {
                arrayList.add(stack2.pop().val);
            }
        }
        return arrayList;
    }
}
