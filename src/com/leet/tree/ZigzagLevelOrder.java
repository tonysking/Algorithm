package com.leet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 */
public class ZigzagLevelOrder {


    // dfs
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        DFS(root, 0, res);
        return res;
    }

    private void DFS(TreeNode node, int level, List<List<Integer>> res) {
        if (level >= res.size()) {
            List<Integer> newLevel = new LinkedList<>();
            newLevel.add(node.val);
            res.add(newLevel);
        } else {
            if (level % 2 == 0) {
                res.get(level).add(node.val);
            } else {
                res.get(level).add(0, node.val);
            }
        }
        if (node.left != null) {
            DFS(node.left, level + 1, res);
        }

        if (node.right != null) {
            DFS(node.right, level + 1, res);
        }
    }


    // bfs
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> arrayList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode last = root;
        TreeNode nextLast = null;
        queue.offer(root);
        boolean isLeft = true;
        while(!queue.isEmpty()) {
            TreeNode pRoot = queue.pollFirst();
            if(isLeft) {
                arrayList.add(pRoot.val);
            } else {
                arrayList.add(0, pRoot.val);
            }
            if(pRoot.left != null) {
                queue.offer(pRoot.left);
                nextLast = pRoot.left;
            }
            if(pRoot.right != null) {
                queue.offer(pRoot.right);
                nextLast = pRoot.right;
            }
            if(last == pRoot) {
                res.add(arrayList);
                arrayList = new ArrayList<>();
                last = nextLast;
                isLeft = !isLeft;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder res = new ZigzagLevelOrder();
        List<List<Integer>> listDFS = res.zigzagLevelOrder(TreeNode.getTree());
        List<List<Integer>> lists = res.zigzagLevelOrder2(TreeNode.getTree());
        listDFS.forEach(a -> System.out.println(a));
        lists.forEach(a -> System.out.println(a));
    }
}
