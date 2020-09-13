package com.company.huawei.paper;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号组合数
 */
public class NumOfRes {
    int res = 0;
    List<String> resList;
    public int getNums(int n) {
        resList = new ArrayList<>();
        if(n == 1) {
            return 1;
        }
        dfs(n, 0, 0, new StringBuilder());
        return res;
    }

    private void dfs(int n, int left, int right, StringBuilder sb) {
        if(left == n && right == n) {
            res++;
            resList.add(new String(sb.toString()));
            return;
        }
        int len = sb.length();
        if(left < n) {
            sb.append("{");
            dfs(n, left + 1, right, sb);
            sb.setLength(len);
        }
        if(right < left) {
            sb.append("}");
            dfs(n, left, right + 1, sb);
            sb.setLength(len);
        }

    }

    public static void main(String[] args) {
        NumOfRes res = new NumOfRes();
        int r = res.getNums(3);
        System.out.println(r);
        System.out.println(res.resList);
    }
}
