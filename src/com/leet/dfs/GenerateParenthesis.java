package com.leet.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 */
public class GenerateParenthesis {
    private List<String> res = new ArrayList<>();
    private int max;
    public List<String> generateParenthesis(int n) {
        max = n;
        dfs(2 * n, "", 0, 0);
        return res;
    }

    // 回溯
    private void dfs(int n, String combination, int open, int close) {
        if(n == 0) {
            res.add(combination);
            return;
        }
        if(open < max) {
            dfs(n - 1, combination + '(', open + 1, close);
        }
        if(close < open) {
            dfs(n - 1, combination + ')', open, close + 1);
        }

    }
}
