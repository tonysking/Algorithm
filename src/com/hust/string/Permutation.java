package com.hust.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return arrayList;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        Arrays.sort(chars); // 先将字符串按字典顺序排序

        boolean[] isContain = new boolean[len]; // 标记数组判断是否访问过
        int count;
        for (int i = 0; i < len; i++) { // 依次得到以i位置字符开头的排列
            count = 0; // 记录添加的字符数
            StringBuilder sb = new StringBuilder();
            dfs(chars, i, count, len, isContain,arrayList, sb);
        }
        return arrayList;
    }


    private void dfs(char[] chars,  int start, int count, int len, boolean[] isContain, ArrayList<String> arrayList, StringBuilder sb) {

        // 加入chars[start]字符
        sb.append(chars[start]);
        isContain[start] = true;
        int index = count; // 记录字符在sb中的下标，以便回溯时删除
        count++;

        if (count == len) { // ---若写入循环中则会重复len次添加进arrayList
            if(!arrayList.contains(sb.toString())) { // 有重复字符时去重
                arrayList.add(sb.toString());
            }
        }
        for (int i = 0; i < len; i++) {
            if (isContain[i] == false && count < len) {
                dfs(chars, i, count, len, isContain, arrayList, sb);
            }
        }
        // 删除chars[start]字符
        count--;
        isContain[start] = false;
        sb.deleteCharAt(index);

    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        ArrayList<String> arrayList = permutation.Permutation("aab");
        System.out.println(arrayList);
    }
}
