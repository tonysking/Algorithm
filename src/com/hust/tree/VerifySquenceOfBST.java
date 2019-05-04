package com.hust.tree;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isPost(sequence, 0, sequence.length - 1);
    }

    private boolean isPost(int[] sequence, int start, int end) {
        //---注意退出条件是 >= 否则会数组越界异常
        if (start >= end) {
            return true;
        }
        int i = start;
        for (; i < end; i++) {
            if(sequence[i] > sequence[end]) break;
        }
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }
        return isPost(sequence, start, i-1) && isPost(sequence, i, end-1);
    }
    /*private boolean isPost(int[] sequence, int start, int end) {
        if (start == end) {
            return true;
        }
        int less = -1; // ---左子树结束下标
        int more = end; // 右子树起始下标
        for (int i = 0; i < end; i++) {  //------ i 从start开始
            // 右子树
            if (sequence[i] > sequence[end]) {
                more = more == end ? i : more; // 只保留最初大于end的下标
            // 左子树
            } else {
                less = i; // ---持续更新
            }
        }
        // 全部为左子树  或  ---全部为右子树
        if (more == end || less == -1) {
            return isPost(sequence, start, end-1);
        } else {
            // 判断右子树是否有小于end的节点
            *//*for (int i = more + 1; i < end; i++) {
                if (sequence[i] < sequence[end]) {
                    return false;
                }
            }*//*
        }
        // 改进
        if (less != more - 1) {
            return false;
        }

        return isPost(sequence, start, more - 1) && isPost(sequence, more, end-1);
    }*/
}
