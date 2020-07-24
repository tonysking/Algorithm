package com.leet.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class LetterCombinations {
    Map<String, String> phoneMap = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            backtrack("", digits);
        }
        return res;
    }

    // 回溯
    private void backtrack(String combination, String digits) {
        if (digits.length() == 0) {
            res.add(combination);
            return;
        }
        String digit = digits.substring(0, 1);
        String letters = phoneMap.get(digit);
        for (char c : letters.toCharArray()) {
            backtrack(combination + c, digits.substring(1));
        }
    }

    public static void main(String[] args) {
        LetterCombinations res = new LetterCombinations();
        List<String> combinations = res.letterCombinations("23");
        System.out.println(combinations);
    }
}
