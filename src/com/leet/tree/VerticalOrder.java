package com.leet.tree;


import javafx.util.Pair;

import java.util.*;

/**
 * VIP
 * 314. 二叉树的垂直遍历
 */
public class VerticalOrder {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>((a, b) -> a - b);
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> nodePair = queue.poll();
            // 获取节点坐标(列数)
            Integer pos = nodePair.getValue();
            root = nodePair.getKey();
            // 将当前节点放入对应坐标所在的List
            List<Integer> posList = map.getOrDefault(pos, new ArrayList<>());
            posList.add(root.val);
            map.put(pos, posList);

            if(root.left != null) {
                queue.add(new Pair<>(root.left, pos - 1));
            }
            if(root.right != null) {
                queue.add(new Pair<>(root.right, pos + 1));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        VerticalOrder res = new VerticalOrder();

        /**
         *          1
         *        2   3
         *      4  56  7
         */
        System.out.println("二叉树结构：");
        TreeNode.getTree().printLevel();

        List<List<Integer>> resOrder = res.verticalOrder(TreeNode.getTree());
        System.out.println("垂直遍历结果：");
        System.out.println(resOrder);
        /*for(List<Integer> list : resOrder) {
            System.out.println();
        }*/
    }
}
