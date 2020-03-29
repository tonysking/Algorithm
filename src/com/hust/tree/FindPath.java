package com.hust.tree;

import java.util.ArrayList;

/**
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {
    private ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
    private int cursum = 0; // 当前和
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return allPaths;
        }
        ArrayList<Integer> paths = new ArrayList<>();
        find(root, target, paths);
        return allPaths;
    }

    public void find(TreeNode root, int target, ArrayList<Integer> paths) {

        if (root == null) {
            return;
        }
        // 当前节点加入路径
        cursum += root.val;
//        System.out.println("当前和："+cursum+" 目标："+target);
        paths.add(root.val);
        if (root.left == null && root.right == null && cursum == target) { // 必须是叶子节点
//            ArrayList<Integer> path = new ArrayList<>();
//            path.addAll(paths);
//            allPaths.add(path);
            allPaths.add(new ArrayList<>(paths)); // ---可直接通过构造函数获得内容和paths一样的ArrayList
            System.out.println(paths);
            System.out.println(allPaths);
        }
        find(root.left, target, paths);
        find(root.right, target, paths);
        // 当前节点移出路径
        cursum -= root.val;
        paths.remove(paths.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode tree = TreeNode.getTree();
        PrintByLevel printByLevel = new PrintByLevel();
        ArrayList<ArrayList<Integer>> print = printByLevel.Print(tree);
        System.out.println(print);

        FindPath findPath = new FindPath();
        ArrayList<ArrayList<Integer>> allPaths = findPath.FindPath(tree, 8);
        System.out.println(allPaths);
    }


}
