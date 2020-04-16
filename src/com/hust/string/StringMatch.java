package com.hust.string;

import java.util.Scanner;

/**
 * 给定字符串 str
 * 给定模式串 exp 可包含：
 *    '.'代表任意字符
 *    '*'表示前一个字符可以0~n个（*不为首字符）
 * 判断str能否被exp匹配
 * eg:
 * str="abc" exp="abc" true
 * str="abc" exp="a.c" true
 * str="abc" exp=".*" true
 * str="" exp="..*" false
 * 注意：""可以匹配"a*"
 */
public class StringMatch {
  public boolean isValid(char[] s, char[] e) {
    for (int i = 0; i < s.length; i++) {
      if (s[i] == '*' || s[i] == '.') {
        return false;
      }
    }
    for (int i = 0; i < e.length; i++) {
      if (e[i] == '*' && (i == 0 || e[i - 1] == '*')) {
        return false;
      }
    }
    return true;
  }

  // recursion
  public boolean isMatch(String str, String exp) {
    if (str == null || exp == null) {
      return false;
    }
    char[] s = str.toCharArray();
    char[] e = exp.toCharArray();
    return isValid(s, e) ? process(s, e, 0 ,0) : false;
  }

  private boolean process(char[] s, char[] e, int si, int ei) {
    // 结束位置
    if (ei == e.length) {
      return si == s.length;
    }
    // 模式串e的下一个字符不为 *
    if (ei + 1 == e.length || e[ei + 1] != '*') { // ei + 1 == e.length为边界条件判断
      return si != s.length
          && (e[ei] == s[si] || e[ei] == '.')
          && process(s, e, si + 1, ei + 1);
    }
    // 模式串e的下一个字符为 *

    // s[si]和e[ei]当前值能匹配
    //    （如a aab和a *b）,
    // 则把s == s[si]的部分循环和e[ei]==*后面的部分匹配，只要有一个能匹配则返回true
    //     (如: aab匹配b,
    //           ab匹配b,
    //            b匹配b返回true)
    while (si != s.length && (e[ei] == s[si] || e[ei] == '.')) {
      if (process(s, e, si, ei + 2)) {
        return true;
      }
      si++;
    }
    // s[si]和e[ei]当前值不能匹配, 则让e[ei]* == "", 判断si是否能和ei + 2匹配
    // ""可以匹配"a*"
    // "b"可以匹配"a*b"
    return process(s, e, si, ei + 2);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      String s = scanner.nextLine();
      String e = scanner.nextLine();
      System.out.println(new StringMatch().isMatch(s, e));
    }
  }

}
