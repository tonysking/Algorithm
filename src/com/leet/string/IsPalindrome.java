package com.leet.string;

/**
 * 125. 验证回文串
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            while (i < j && !isLegal(chars, i)) {
                i++;
            }
            while (i < j && !isLegal(chars, j)) {
                j--;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isLegal(char[] chars, int index) {
        // Character.isLetterOrDigit(chars[index])
        if (chars[index] >= 'A' && chars[index] <= 'Z') {
            chars[index] = (char) (chars[index] - 'A' + 'a');
            return true;
        } else if (chars[index] >= 'a' && chars[index] <= 'z') {
            return true;
        } else if (chars[index] >= '0' && chars[index] <= '9') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsPalindrome res = new IsPalindrome();
        boolean b = res.isPalindrome("A man, a plan, a canal: Panama");
        boolean b2 = res.isPalindrome(".,");
        boolean b3 = res.isPalindrome("0P");
        System.out.println(b);
        System.out.println(b2);
        System.out.println(b3);
    }
}
