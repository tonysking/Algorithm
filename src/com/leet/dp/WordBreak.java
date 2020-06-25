package com.leet.dp;

import java.util.*;

/**
 *  139. 单词拆分
 *  dp[i] 表示字符串 s 前 i个字符组成的字符串 s[0..i−1]是否能被空格拆分成若干个字典中出现的单词
 *  dp[i]=dp[j] && check(s[j..i−1])
 * 检查一个[字符串]是否出现在给定的[字符串列表]里一般可以考虑哈希表来快速判断
 */
public class WordBreak {

    // dp
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }


    // [单词dfs]超时
    // 可通过[下标dfs](String s, int index, List<String> wordDict) + 记忆化搜索int[s.length()];
    public boolean wordBreakR(String s, List<String> wordDict) {
        if (wordDict.isEmpty()) {
            return false;
        }
        if (s.replace("|", "").isEmpty()) {
            return true;
        }
        boolean flag = false;
        for(String word : wordDict) {
            if (s.contains(word)) {
                // 注： 每次尝试时s本身保持不变
                // 替换为 | 而不是 "", 如ccbb  bc,cb
                flag = wordBreak(s.replace(word, "|"), wordDict);
                if (flag) break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        String s2 = "leetcode";
        List<String> wordDict2 = Arrays.asList("leet","code");
        String s3 = "cars";
        List<String> wordDict3 = Arrays.asList("car","ca", "rs");
        String s4 = "ccbb";
        List<String> wordDict4 = Arrays.asList("bc","cb");
        WordBreak res = new WordBreak();
        boolean b = res.wordBreak(s, wordDict);
        boolean b2 = res.wordBreak(s2, wordDict2);
        boolean b3 = res.wordBreak(s3, wordDict3);
        boolean b4 = res.wordBreak(s4, wordDict4);
        System.out.println(b);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
