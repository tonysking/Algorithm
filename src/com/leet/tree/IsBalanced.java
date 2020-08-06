package com.leet.tree;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 剑指 Offer 55 - II. 平衡二叉树
 */
public class IsBalanced {
    public static boolean isBalanced(TreeNode root) {
        return treeHeight(root) >= 0;
    }

    public static int treeHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = treeHeight(root.left);
        int right = treeHeight(root.right);
        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 第一行输入两个整数n和root：n表示二叉树的总节点个数，root表示二叉树的根节点。
        int n = sc.nextInt();
        int rootV = sc.nextInt();
        TreeNode root = new TreeNode(rootV);
        HashMap<Integer, TreeNode> map = new HashMap<>(n);
        map.put(rootV, root);
        // 以下n行每行三个整数fa，lch，rch，表示fa的左儿子为lch，右儿子为rch。(如果lch为0则表示fa没有左儿子，rch同理)
        /*
            eg:
            3 1
            1 2 3
            2 0 0
            3 0 0
         */
        for (int i = 0; i < n; i++) {
            int nodeV = sc.nextInt();
            TreeNode node = map.getOrDefault(nodeV, new TreeNode(nodeV));
            int leftV = sc.nextInt();
            int rightV = sc.nextInt();
            node.left = leftV == 0 ? null : map.getOrDefault(leftV, new TreeNode(leftV));
            node.right = rightV == 0 ? null : map.getOrDefault(rightV, new TreeNode(rightV));
        }
        System.out.println(isBalanced(root));
    }

}
