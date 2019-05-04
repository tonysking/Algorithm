package com.hust.tree;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReconstructBT {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        //---边界
        if (pre==null || in==null) {
            return null;
        }
        int len = pre.length;
        //---改进部分
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(in[i],i);
        }

        return rePre(pre,0,len-1,in,0,len-1,map);
    }

    private TreeNode rePre(int[] pre, int start, int end, int[] in, int inStart, int inEnd,HashMap<Integer,Integer> map) {

        //边界
        if (start>end || inStart>inEnd){
            return null;
        }
        TreeNode root = new TreeNode(pre[start]);
        int inRoot = 0;
        //---改进：提前将in数组内容放进hashMap中 此处直接map.get(pre[start])即可
        /*for (int i = inStart; i <=inEnd; i++) {
            if (pre[start] == in[i]) {
                inRoot = i;
            }
        }*/
        inRoot = map.get(pre[start]);
        //左子树长度
        int leftLen = inRoot - inStart;

        //左子树的end:  start+leftLen(不要少了start)
        root.left = rePre(pre,start+1,start+leftLen,in,inStart,inRoot-1,map);
        //---右子树的start:  start+leftLen+1(不要少了start)
        root.right = rePre(pre,start+leftLen+1,end,in,inRoot+1,inEnd,map);
        return root;
    }
}
