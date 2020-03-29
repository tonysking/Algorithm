package com.hust.bytedance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 字节跳动2019夏令营笔试题第二轮
 * thisisadog
 * this thisis is a dog
 */
public class IsPiece {
    public static void main(String[] args) {

//        Scanner sc =  new Scanner(System.in);
//        String svar = sc.nextLine();
//        String spieces = sc.nextLine();

        String var = "thisisadog";
        String pieces = "this thisis is a dog";
        char[] vars = var.toCharArray();
        String[] split = pieces.split(" ");
        System.out.println(isPiecesMap(var, pieces)? "True" : "False");



//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < split.length; i++) {
//            sb.append(split[i]);
//        }
//        System.out.println(sb.toString());
//
//
//        printString(split);
//        HashSet<String> hashSet = new HashSet<>();
//        ArrayList<String> arrayList = new ArrayList<>();
//        exchangeDfs(split,0,hashSet);
//        System.out.println(arrayList.size());
//        for (String a: hashSet) {
//            if (a.equals(var)) {
//                System.out.println("yes");
//            }
//            printString2(a);
//        }

    }

    public static boolean isSame() {
        return true;
    }

    public static boolean isPiecesMap(String var, String pieces) {
        char[] vars = var.toCharArray();
        String[] split = pieces.split(" ");
        // 以首字母为标识存入map
        HashMap<Character, String> hashMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i] != ""){
                hashMap.put(split[i].charAt(0), split[i]);
            }
        }
        for (int i = 0; i < vars.length; i++) {
            if (hashMap.containsKey(vars[i])){
                String s = hashMap.get(vars[i]);
                // 逐一比较字母
                for (int j = 0; j < s.length(); j++) {
                    if (vars[i++] != s.charAt(j)) {
                        return false;
                    }
                }
//                i += s.length();
            } else {
                return false;
            }
        }
        return true;
    }





    public boolean isPieces(String var, String pieces) {
        if (var == null || pieces == null) {
            return false;
        }
        if (var.equals(pieces)) {
            return true;
        }
        String[] split = pieces.split(" ");
        HashSet<String> hashSet = new HashSet<>();
        return true;
    }

    // 求全排列
    private static void exchangeDfs(String[] pieces, int i,HashSet<String> hashSet ) {
        if (i == pieces.length && !hashSet.contains(pieces)) {
//            printString(pieces);
            hashSet.add(String.valueOf(pieces));
            return;
        }
        for (int j = i; j < pieces.length; j++) { // 递归得到从i到len-1位置开始的全排列
            swap(pieces, i, j);
            exchangeDfs(pieces, i + 1, hashSet);
            swap(pieces, i, j);
        }
    }
    private static void swap(String[] pieces, int i, int j) {
        String temp = pieces[i];
        pieces[i] = pieces[j];
        pieces[j] = temp;
    }

    private static void printString(String[] split) {
        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i]+" ");
        }
        System.out.println();
    }

    private static void printString2(String split) {
        char[] chars = split.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
        System.out.println();
    }

}
