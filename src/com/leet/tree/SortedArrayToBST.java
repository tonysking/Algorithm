package com.leet.tree;


/**
 * 108. 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return arrayToBST(nums, 0, n);
    }

    private TreeNode arrayToBST(int[] nums, int l, int r) {
        // 若l == r继续运行，mid一直为相同值无限循环
        if (l < 0 || r > nums.length || l >= r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = arrayToBST(nums, l, mid);
        root.right = arrayToBST(nums, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        SortedArrayToBST res = new SortedArrayToBST();
        int[] a = {-10, -3, 0, 5, 9};
        TreeNode tree = res.sortedArrayToBST(a);
        tree.printLevel();

    }
}
