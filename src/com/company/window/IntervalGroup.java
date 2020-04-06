package com.company.window;

import java.util.Scanner;

/**
 * 美团骑手包裹区间分组
 * 如RETTEBTAE代表一组流水线包裹共9个，同时分配给了名字为A B E R T的5名骑手,
 * 请在不打乱流水线产出顺序的情况下，把这组包裹划分为尽可能多的片段，
 * 同一个骑手只会出现在其中的一个片段，返回一个表示每个包裹片段的长度的列表。
 * eg:
 * 输入：MPMPCPMCMDEFEGDEHINHKLIN
 * 输出：9 7 8
 * 即划分结果为MPMPCPMCM,DEFEGDE,HINHKLIN。
 */
public class IntervalGroup {
  public static void getIntervalGroup(String s) {
    if (s.length() == 1) {
      System.out.println(1);
    }
    char[] chars = s.toCharArray();
    for (int i = 0; i < s.length(); i++) {
      // 当前字符的首尾下标
      char c = chars[i];
      int lastIndex = s.lastIndexOf(c);
      // 当前字符首位内部遍历
      int j = i + 1;
      while (j < lastIndex) {
        char innerChar = chars[j];
        // 内部字符尾部下标超过当前字符则更新尾部
        lastIndex = Math.max(lastIndex, s.lastIndexOf(innerChar));
        j++;
      }
      System.out.println(lastIndex - i + 1);
      i = lastIndex;
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.nextLine();
    System.out.println("读取字符串：" + s);
    getIntervalGroup(s);
  }
}
