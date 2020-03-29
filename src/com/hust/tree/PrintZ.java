package com.hust.tree;

import java.util.ArrayList;
import java.util.LinkedList;
// 只是用一个LinkedList实现之字形打印
// 利用LinkedList双向链表的性质，顺序和逆序分在头部和尾部弹出
public class PrintZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> all= new ArrayList<>(); // 将节点分层放入all中
        if (pRoot == null) {
            return all;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList();
        boolean flag = true; // true是顺序（默认奇数层 顺序）
        TreeNode last = pRoot; // 该层最后一个节点、
        // 注： 每一层最先进入的孩子节点 都是 下一层弹出的最后一个节点
        TreeNode nLast = null;  // 下一层最后一个节点
        queue.offer(pRoot);
        while(!queue.isEmpty()) {
            // 奇数层
            // 顺序
            /* 注：
              弹出第一个
              先进左孩子
              往尾部加
             */
            if (flag == true) {

                pRoot = queue.pollFirst(); // 弹出第一个
                arrayList.add(pRoot.val);
                if (pRoot.left != null) { // 先进左孩子
                    queue.addLast(pRoot.left); // 往尾部加
                    nLast = nLast == null ? pRoot.left : nLast;
                }
                if (pRoot.right != null) {
                    queue.addLast(pRoot.right);
                    nLast = nLast == null  ? pRoot.right : nLast;

                }
            } else {
                // 偶数层
                // 倒序
                /* 注：
                    弹出最后一个
                    先进右孩子
                    往头部加
                */
                pRoot = queue.pollLast(); // 弹出最后一个
                arrayList.add(pRoot.val);

                if (pRoot.right != null) { // 先进右孩子
                    queue.addFirst(pRoot.right); // 往头部加
                    nLast = nLast == null ?pRoot.right : nLast;

                }
                if (pRoot.left != null) {
                    queue.addFirst(pRoot.left);
                    nLast = nLast == null ?pRoot.left :nLast;
                }

            }

            if (pRoot == last) { // 若当前节点是该层最后一个节点
                all.add(arrayList);
                arrayList = new ArrayList<>();
                last = nLast;
                nLast = null; // 每次把nLast置位null
                flag = !flag; // 标志位取反，进入下一层
            }
        }
        return all;
    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        PrintZ printZ = new PrintZ();
        ArrayList<ArrayList<Integer>> print = printZ.Print(tree);
        System.out.println(print);
    }
}
