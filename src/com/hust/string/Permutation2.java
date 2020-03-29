package com.hust.string;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串的排列（全排列问题）
 */
public class Permutation2 {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return arrayList;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars); // 先将字符串按字典顺序排序
        exchangeDfs(chars, 0, arrayList); // 从0位置开始的全排列
        return arrayList;
    }

    // 邻位交换法
    private void exchangeDfs(char[] chars, int i, ArrayList<String> arrayList) {
        if (i == chars.length && !arrayList.contains(chars)) {
            arrayList.add(new String(chars));
            return;
        }
        for (int j = i; j < chars.length; j++) { // 递归得到从i到len-1位置开始的全排列
            swap(chars, i, j);
            exchangeDfs(chars, i + 1, arrayList);
            swap(chars, i, j);
        }
    }

/*    // 邻位交换法 -- 非递归 -- failed
    private ArrayList<String> exchangeDP(char[] chars) {
        ArrayList<String> arrayList = new ArrayList<>();
        String[][] all = new String[chars.length+2][chars.length*chars.length]; // String[i]保存以i开头的全排列

        all[chars.length - 1][0] = String.valueOf(chars[chars.length-1]);
//        System.out.println(all[chars.length - 1][0]);
        int k = 0; // 记录从i开始的全排列的个数
        for (int i = chars.length-1; i >= 0; i--) {
            k = 0;
            for (int j = i; j < chars.length; j++) {
                all[i][k] = chars[i] + all[i+1][k];
                k++;
                swap(chars, i, j);
                all[i][k] = String.valueOf(chars, i, chars.length-i);
//                if (all[i+1][k] != null) {
//                    System.out.println(all[i+1][k]);
//                    all[i][k] = chars[i] + all[i+1][k];
//                    System.out.println(all[i][k]);
//                    k++;
//                }
                k++;

            }
            for (int j = 0; j < all[i].length; j++) {

                System.out.print(all[i][j] + " ");
            }
            System.out.println();
        }

        k = all[0].length;
        while (k-- > 0) {
            arrayList.add(all[0][k]);
        }
        return arrayList;
    }*/

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    public static void main(String[] args) {
        Permutation2 permutation2 = new Permutation2();
        ArrayList<String> list = permutation2.Permutation("aab");
        System.out.println(list);

//        ArrayList<String> arrayList = permutation2.exchangeDP("abc".toCharArray());
//        System.out.println(arrayList);
    }
}
