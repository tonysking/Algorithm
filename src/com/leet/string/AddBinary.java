package com.leet.string;

/**
 * 67. 二进制求和
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        String aR = new StringBuilder(a).reverse().toString();
        String bR = new StringBuilder(b).reverse().toString();
        char[] aChars = aR.toCharArray();
        char[] bChars = bR.toCharArray();
        if (aChars.length < bChars.length) {
            char[] tmp = aChars;
            aChars = bChars;
            bChars = tmp;
        }

        // a较长
        StringBuilder sb = new StringBuilder();
        boolean hasCarry = false;
        for (int i = 0; i < aChars.length; i++) {
            if (i < bChars.length) {
                if (aChars[i] == bChars[i]) {
                    sb.append(hasCarry ? '1' : '0');
                    hasCarry = aChars[i] == '1';
                } else {
                    sb.append(hasCarry ? '0' : '1');
                }
            } else {
                if (aChars[i] == '0') {
                    sb.append(hasCarry ? '1' : '0');
                    hasCarry = false;
                } else {
                    sb.append(hasCarry ? '0' : '1');
                }
            }
        }
        if (hasCarry) {
            sb.append('1');
        }
        StringBuilder res = sb.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        AddBinary res = new AddBinary();
        String s = res.addBinary("110010", "10111");
        System.out.println(s);
    }
}
