package com.leet.string;

public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) {
      return "";
    }
    String shortStr = "";
    int minLength = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      if (strs[i].length() < minLength) {
        minLength = strs[i].length();
        shortStr = strs[i];
      }
    }
    int end = 0;
    for (int i = 0; i < minLength; i++) {
      char tmp = shortStr.charAt(i);
      for (int j = 0; j < strs.length; j++) {
        if (strs[j].charAt(i) != tmp) {
          return shortStr.substring(0, end);
        }
      }
      end++;
    }
    return shortStr.substring(0, end);
  }

  public static void main(String[] args) {
    LongestCommonPrefix res = new LongestCommonPrefix();
    String[] strs = new String[] {"flower","flow","flight"};
    String s = res.longestCommonPrefix(strs);
    System.out.println(s);
  }
}
