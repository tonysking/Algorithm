package com.leet.string;

public class LongestPalindrome {
  public String longestPalindrome(String s) {
    if(s == null) {
      return null;
    }
    if (s.isEmpty()) {
      return s;
    }
    char[] chars = s.toCharArray();
    // 保存判断结果
    int[][] isPalindome = new int[chars.length + 1][chars.length + 1];

    int h = 0;
    int t = 0;
    int maxLength = 0;
    for (int i = 0; i < chars.length; i++) {
      for (int j = 0; j < chars.length; j++) {
        // 若当前子串长度<=当前最长回文串长度，则不需要回文判断
        if (j - i > maxLength && isPalindome(i, j, chars, isPalindome)) {
          maxLength = j - i;
          h = i;
          t = j;
        }
      }
    }
    return s.substring(h, t + 1);
  }

  public String longestPalindromeDP(String s) {
    if(s == null) {
      return null;
    }
    if (s.length() <= 1) {
      return s;
    }
    char[] chars = s.toCharArray();
    // 保存判断结果
    boolean[][] isPalindome = new boolean[chars.length][chars.length];

    int h = 0;
    int t = 0;
    int maxLength = 0;
    // 注意DP顺序，isPalindome[i][j]依赖于其左下角的值(i+1, j-1)，
    // 故不可按行从上往下遍历，应按列从左到右遍历
    for (int j = 1; j < chars.length; j++) {
      for (int i = 0; i < j; i++) {
        if (chars[i] == chars[j] && (j - i < 3 || isPalindome[i + 1][j - 1])) {
          isPalindome[i][j] = true;
        }
        if (j - i + 1 > maxLength && isPalindome[i][j]) {
          maxLength = j - i + 1;
          h = i;
          t = j;
        }
      }
    }
    return s.substring(h, t + 1);
  }


  // recursive
  public boolean isPalindome(int i, int j, char[] chars, int[][] isPalindome) {
    if (isPalindome[i][j] != 0) {
      return isPalindome[i][j] == 1;
    }
    if (i >= j) {
      isPalindome[i][j] = 1;
      return true;
    }
    if (chars[i] == chars[j]) {
      isPalindome[i][j] =  isPalindome(i + 1, j - 1, chars, isPalindome) ? 1 : -1;
      return isPalindome[i][j] == 1;
    }
    return false;
  }

  public static void main(String[] args) {
    LongestPalindrome res = new LongestPalindrome();
    String s = res.longestPalindrome("babad");
    String sDP = res.longestPalindromeDP("ccc");
    System.out.println(s);
    System.out.println(sDP);
  }
}
