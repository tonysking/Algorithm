package com.hust.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化和反序列化二叉树
 */
public class SerializeAndDeserialize {
    String Serialize(TreeNode root) {
        if(root == null) {
            return "#!";
        }
        String res = root.val+"!";
        res += Serialize(root.left);
        res += Serialize(root.right);
        return res;
    }
    public static TreeNode Deserialize(String str) {
        String[] values = str.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < values.length; i++) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static TreeNode reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(value));
        root.left = reconPreOrder(queue);
        root.right = reconPreOrder(queue);
        return root;
    }
}
