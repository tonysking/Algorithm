package com.leet.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原IP地址
 */
public class RestoreIpAddresses {
    List<String> res;
    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(s, 0, sb, 0);
        return res;
    }

    private void dfs(String s, int index, StringBuilder sb, int level) {
        // 保存sb的长度便于回溯
        int len = sb.length();

        if(level == 3 && (index + 3 < s.length())) {
            return;
        }

        if(level == 4) {
            if(index == s.length()) {
                sb.setLength(sb.length() - 1);
                res.add(sb.toString());
            }
            return;
        }

        // 不到第4层用完字符串
        if(index == s.length()) {
            return;
        }

        char[] chars = s.toCharArray();
        int num = 0;

        // 不允许出现以0开头的多位数
        int maxLen = chars[index] == '0' ? 1 : 3;
        for(int i = index; i < index + maxLen && i < s.length(); i++) {
//            num = Integer.parseInt(s.substring(index, i + 1));
            num = num * 10 + (s.charAt(i) - '0');
            if(num <= 255) {
                sb.append(s.substring(index, i + 1));
                sb.append('.');
                dfs(s, i + 1, sb, level + 1);
                // sb回溯
                sb.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        RestoreIpAddresses resolve = new RestoreIpAddresses();
        List<String> ips = resolve.restoreIpAddresses("25525511135");
        List<String> ips2 = resolve.restoreIpAddresses("0000");
        List<String> ips3 = resolve.restoreIpAddresses("010010");
        List<String> ips4 = resolve.restoreIpAddresses("1111");
        ips.forEach(ip -> System.out.println(ip));
        ips2.forEach(ip -> System.out.println(ip));
        ips3.forEach(ip -> System.out.println(ip));
        ips4.forEach(ip -> System.out.println(ip));
    }
}
