package com.leet.string;

import java.util.Map;

public class LengthOfLongestSubstring {

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty() || s == null) {
      return 0;
    }

    char[] chars = s.toCharArray();
    int[] max = new int[chars.length];

    int cur = 0;
    int tail = -1;
    int maxLength = 1;
    int curMax = 1;
    while (cur < chars.length) {
      // 从当前cur获得cur之后第一次重复的位置tail，不断更新tail
      tail = getLatestTail(chars, cur, max);
      curMax = Math.max(maxLength, tail - cur);
      for (int i = cur + 1; i < tail; i++) {
        int latestTail = getLatestTail(chars, i, max);
        if(latestTail < tail) {
          tail = latestTail;
          curMax = tail - cur;
        }
      }
      maxLength = Math.max(maxLength, curMax);
      cur++;
    }
    return maxLength;
  }

  public int lengthOfLongestSubstring2plus(String s) {
    if (s.isEmpty() || s == null) {
      return 0;
    }

    char[] chars = s.toCharArray();
    int[] map = new int[chars.length];
    int start = 0;
    int cur = 0;
    int curMax = 0;
    int maxLength = 0;
    while (cur < chars.length) {
      // 从当前cur判断start~cur之间cur是否重复
      char tmp = chars[cur];
      if (map[cur] > 0) {
        start = map[cur] + 1;
      } else {
        for (int i = start; i < cur; i++) {
          if (chars[i] == tmp) {
            map[cur] = i;
            start = i + 1;
            break;
          }
        }
      }

      cur++;
      curMax = cur - start;
      maxLength = Math.max(maxLength, curMax);
    }
    return maxLength;
  }

  public int lengthOfLongestSubstring2(String s) {
    if (s.isEmpty() || s == null) {
      return 0;
    }

    char[] chars = s.toCharArray();
    int start = 0;
    int cur = 0;
    int curMax = 0;
    int maxLength = 0;
    while (cur < chars.length) {
      // 从当前cur判断start~cur之间cur是否重复
      char tmp = chars[cur];
      for (int i = start; i < cur; i++) {
        if (chars[i] == tmp) {
          start = i + 1;
          break;
        }
      }
      cur++;
      curMax = cur - start;
      maxLength = Math.max(maxLength, curMax);
    }
    return maxLength;
  }

  public int getLatestTail(char[] chars, int cur, int[] max) {
    if (max[cur] > 0) {
      return max[cur];
    }
    for (int i = cur + 1; i < chars.length; i++) {
      if (chars[i] == chars[cur]) {
        max[cur] = i;
        return i;
      }
    }
    max[cur] = chars.length;
    return chars.length;
  }

  public static void main(String[] args) {
    LengthOfLongestSubstring res = new LengthOfLongestSubstring();
    int max = res.lengthOfLongestSubstring("abcabcbb");
    int max2 = res.lengthOfLongestSubstring2("pwwkew");
    System.out.println(max);
    System.out.println(max2);
  }
}
