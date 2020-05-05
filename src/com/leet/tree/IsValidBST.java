package com.leet.tree;

public class IsValidBST {
  private static class BSTResult {
    boolean isBST;
    int min;
    int max;

    BSTResult(boolean isBST, int min, int max) {
      this.isBST = isBST;
      this.min = min;
      this.max = max;
    }
  }

  public BSTResult isBST(TreeNode root) {
    if (root == null) {
      return new BSTResult(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    if (root.left != null && root.left.val >= root.val) {
      return new BSTResult(false, 0, 0);
    }
    if (root.right != null && root.right.val <= root.val) {
      return new BSTResult(false, 0, 0);
    }

    BSTResult left = isBST(root.left);
    BSTResult right = isBST(root.right);
    if (!left.isBST || !right.isBST) {
      return new BSTResult(false, 0, 0);
    }


    // 注意边界条件，如TreeNode = [2147483647]
    if (left.max != Integer.MIN_VALUE && left.max >= root.val ||
        right.min != Integer.MAX_VALUE && right.min <= root.val) {
      return new BSTResult(false, 0, 0);
    }

    int subMax = Math.max(left.max, right.max);
    int subMin = Math.min(left.min, right.min);
    int max = Math.max(root.val, subMax);
    int min = Math.min(root.val, subMin);
    return new BSTResult(true, min, max);

  }

  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isBST(root).isBST;
  }



  // 递归简化
  // 以 node 为根的子树，判断子树中所有节点的值是否都在 (l,r) 的范围内（注意是开区间）
  public boolean helper(TreeNode node, Integer lower, Integer upper) {
    if (node == null) return true;

    int val = node.val;
    if (lower != null && val <= lower) return false;
    if (upper != null && val >= upper) return false;

    if (! helper(node.right, val, upper)) return false;
    if (! helper(node.left, lower, val)) return false;
    return true;
  }

  public boolean isValidBST2(TreeNode root) {
    return helper(root, null, null);
  }

}
