package com.hust.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PrintByLevel {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> levelList = new ArrayList<>();
        if (pRoot == null) {
            return arrayLists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        int level = 1;
        TreeNode last = pRoot;  //当前行最右节点
        TreeNode nLast = null;  //下一行最右节点
        queue.add(pRoot);
        //--循环条件
        while (!queue.isEmpty()) {
            pRoot = queue.poll();
            levelList.add(pRoot.val);

            if (pRoot.left != null) {
                queue.add(pRoot.left);
                nLast = pRoot.left;
            }
            if (pRoot.right != null) {
                queue.add(pRoot.right);
                nLast = pRoot.right;
            }
            // 若加上&& !queue.isEmpty()则最后一次出队后不会执行，无最后一行的结果
            if (pRoot == last){
                arrayLists.add(levelList);
                levelList = new ArrayList<>();
                last = nLast;
            }
        }
        return arrayLists;
    }
}
