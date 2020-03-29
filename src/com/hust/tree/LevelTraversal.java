package com.hust.tree;
import java.util.*;

public class LevelTraversal {
    public static ArrayList<Integer> levelTraversal(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            root = queue.poll();
            arrayList.add(root.val);
            if(root.left != null) {
                queue.add(root.left);
            }
            if(root.right != null) {
                queue.add(root.right);
            }
        }
       return arrayList;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        ArrayList<Integer> treeNodes = levelTraversal(tree);
        System.out.println(treeNodes);
    }
}
