package com.leet.string;


/**
 * 394. 字符串解码
 */
public class DecodeString {

    static class DecodeS {
        int end;
        String s;
        DecodeS(int end, String s) {
            this.end = end;
            this.s = s;
        }
    }

    public String decodeString(String s) {
        return getDecode(s.toCharArray(), 0).s;
    }

    public DecodeS getDecode(char[] chars, int start) {
        StringBuilder sb = new StringBuilder();
        int end = start;
        int dupNum = 0;
        for(int i = start; i < chars.length; i++) {
            if(chars[i] >= '0' && chars[i] <= '9') {
                dupNum = dupNum * 10 + (int) chars[i] - '0';
            } else if(chars[i] == '[') {
                DecodeS decode = getDecode(chars, i + 1);
                while (dupNum > 0) {
                    sb.append(decode.s);
                    dupNum--;
                }
                i = decode.end;
            } else if(chars[i] == ']') {
                end = i;
                break;
            } else {
                sb.append(chars[i]);
            }
        }
        return new DecodeS(end, sb.toString());
    }

    public static void main(String[] args) {
        DecodeString res = new DecodeString();
        String s = res.decodeString("3[a]2[bc]");
        String s2 = res.decodeString("3[a2[c]]");
        System.out.println(s);
        System.out.println(s2);
    }
}
