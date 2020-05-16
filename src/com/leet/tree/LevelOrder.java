package com.leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode last = root;
        TreeNode nextLast = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            levelList.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
                nextLast = poll.left;
            }
            if (poll.right != null) {
                queue.add(poll.right);
                nextLast = poll.right;
            }
            if (poll == last) {
                lists.add(levelList);
                levelList = new ArrayList<>();
                last = nextLast;
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        LevelOrder res = new LevelOrder();
        List<List<Integer>> lists = res.levelOrder(TreeNode.getTree());
        for(List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
