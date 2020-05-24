package com.leet.string;

import java.util.Arrays;

/**
 * 1371.每个元音包含偶数次的最长子字符串
 *
 *  定义 pre[i][k] 表示在字符串前 i个字符中，第 k 个元音字母一共出现的次数。
 *  要做的就是快速找到最小的 j∈[0,i)，满足 pre[i][k]−pre[j][k]（即每一个元音字母出现的次数）均为偶数，
 *  那么以 i结尾的最长字符串 s[j+1,i]长度就是 i−j。
 *
 *  从维护元音字母【出现的次数】改作【出现次数的奇偶性】。
 *  0 代表出现了偶数次，1 代表出现了奇数次
 *
 *  s[j+1,i]满足条件当且仅当对于所有的 k，pre[i][k]和 pre[j][k]的奇偶性都相等，
 *  此时我们就可以利用哈希表存储每一种奇偶性（即考虑所有的元音字母）对应最早出现的位置，边遍历边更新答案。
 *
 *  a e i o u 出现的奇偶性 压缩成二进制数的 [(00000)2,(11111)2]的范围，转成十进制数即 [0,31]
 *  不再需要使用哈希表，直接用一个长度为 32的数组来存储对应状态出现的【最早位置】即可
 */
public class FindTheLongestSubstring {

    //  用一个长度32的数组pos，存放 从0到i 【第一次出现[a,e,i,o,u]各种奇偶情况的位置】
    //  当出现第二次时，通过将相同奇偶情况的位置相减，得到满足要求的字符串长度。
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        // status: 当前节点所有元音字母的奇偶性
        // pos: 存储这些奇偶性状态第一次出现的数组下标
        int ans = 0, status = 0;
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            // 要记录一个字符都没有时的状态，也就是pos[0] = 0，所以将字符串下标都加了1。
            // 这样就覆盖了答案是从字符串一开始到后面的某个位置或者整个字符串的情况。

            // status第二次出现，即相同奇偶，则计算结果
            if (pos[status] >= 0) {
                ans = Math.max(ans, i + 1 - pos[status]);
            } else {
                // 只记录status第一次出现的位置
                pos[status] = i + 1;
            }
        }
        return ans;
    }
}
