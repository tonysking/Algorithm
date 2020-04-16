package com.company.string;

import java.util.Scanner;
// 保存状态 --- 通过: 52 ms
/**
 * 美团2020
 * 字符串模式匹配
 * 链接：https://www.nowcoder.com/questionTerminal/2e2510b2e41e4d3b922416e51afc077b
 *      https://leetcode-cn.com/problems/wildcard-matching/submissions/
 * 来源：牛客网
 *
 * 给出两个字符串，分别是模式串P和目标串T，判断模式串和目标串是否匹配，匹配输出 1，不匹配输出 0。
 * 模式串中‘？’可以匹配目标串中的任何字符， ’*’可以匹配目标串中的任何长度的串，
 * 例如P=a?b，T=acb，则P 和 T 匹配。
 *
 * "acdcb"
 * "a*c?b"
 *
 * ""
 * "*"
 *
 * "a"
 * "a*"
 *
 * 超时demo:
 * "bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab"
 * "b*b*ab**ba*b**b***bba"
 *
 */
public class StringMatchCut {

  public boolean isValid(char[] s, char[] e) {
    for (int i = 0; i < s.length; i++) {
      if (s[i] == '?' || s[i] == '*') {
        return false;
      }
    }
    return true;
  }

  public boolean isMatch(String str, String exp) {
    if (str == null || exp == null) {
      return false;
    }
    char[] s = str.toCharArray();
    char[] e = exp.toCharArray();
    // 判断是否计算过
    boolean[][] flag = new boolean[s.length + 1][e.length + 1];
    // 保存计算过的结果
    boolean[][] state = new boolean[s.length + 1][e.length + 1];
    return isValid(s, e) ? process(s, e, 0 ,0, state, flag) : false;
  }

  private boolean process(char[] s, char[] e, int si, int ei, boolean[][] state, boolean[][] flag) {
    if (ei == e.length) {
      return si == s.length;
    }
    // e当前不为*
    if (e[ei] != '*') {
      if (si != s.length  // 该条件忘加导致数组越界错误
          && (s[si] == e[ei] || e[ei] == '?')) {
        // 未计算过
        if (!flag[si + 1][ei + 1]) {
          state[si + 1][ei + 1] = process(s, e, si + 1, ei + 1, state, flag);
          flag[si + 1][ei + 1] = true;
          return state[si + 1][ei + 1];
        // 已计算过
        } else {
          return state[si + 1][ei + 1];
        }
      } else {
        return false;
      }
    }
    // e当前为*
    while (si != s.length) {
      if (ei + 1 == e.length) {
        return true;
      }
      // 未计算过
      if (!flag[si][ei + 1]) {
        state[si][ei + 1] = process(s, e, si, ei + 1, state, flag);
        flag[si][ei + 1] = true;
      }
      if (state[si][ei + 1]) {
        return true;
      }
      si++;
    }
    // 不能直接返回
    // e当前为*, si已经等于s.lefalse,
    //    // eg: "", "*"  || a, a*ngth却, 还需判断ei + 1
    return process(s, e, si, ei + 1, state, flag);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {
      String s = sc.nextLine();
      String e = sc.nextLine();
      System.out.println(new StringMatchCut().isMatch(s, e));
    }
  }
}
