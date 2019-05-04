package com.hust.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * preorder traversal
 * iteratively
 */
public class PreorderTraversal {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                root = stack.pop();
                arrayList.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null){
                    stack.push(root.left);
                }
            }
        }
        return arrayList;
    }
}
