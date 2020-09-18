package com.leet.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 */
public class BinaryTreePaths {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        getPath(root, sb);
        return res;
    }

    public void getPath(TreeNode root, StringBuilder sb) {
        if(root != null) {
            int len = sb.length();
            sb.append(String.valueOf(root.val));
            sb.append("->");

            if(root.left == null && root.right == null) {
                sb.setLength(sb.length() - 2);
                res.add(sb.toString());
            }

            getPath(root.left, sb);
            getPath(root.right, sb);
            sb.setLength(len);
        }
    }

    public static void main(String[] args) {
        BinaryTreePaths res = new BinaryTreePaths();
        List<String> treePaths = res.binaryTreePaths(TreeNode.getTree());
        System.out.println(treePaths);
        System.out.println(String.join("->", new String[]{"1","2"}));
    }
}
