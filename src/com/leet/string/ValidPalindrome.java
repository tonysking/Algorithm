package com.leet.string;

public class ValidPalindrome {
    public boolean validPalindrome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            if (chars[i] != chars[j]) {
                return isPalin(chars, i + 1, j) || isPalin(chars, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalin(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }


    // 递归
    public boolean validPalindrome2(String s) {
        char[] chars = s.toCharArray();
        return validPalindromeR(chars, 0, chars.length - 1, false);
    }

    public boolean validPalindromeR(char[] chars, int i, int j, boolean isDelete) {
        if (i >= j) {
            return true;
        }
        if (chars[i] == chars[j]) {
            return validPalindromeR(chars, i + 1, j - 1, isDelete);
        }
        if (!isDelete) {
            if (i + 1 == j) {
                return true;
            }
            return validPalindromeR(chars, i, j - 1, true) ||
                    validPalindromeR(chars, i + 1, j, true);
        }
        return false;

    }

    public static void main(String[] args) {
        ValidPalindrome res = new ValidPalindrome();
        boolean b = res.validPalindrome2("abc");
        boolean b1 = res.validPalindrome2("abca");
        System.out.println(b);
        System.out.println(b1);
        boolean f3R = res.validPalindrome2("ebcbbececabbacecbbcbe");
        // ebcbb e cecabbacec bbcbe
        boolean f3 = res.validPalindrome("ebcbbececabbacecbbcbe");
        System.out.println(f3R);
        System.out.println(f3);
    }
}
