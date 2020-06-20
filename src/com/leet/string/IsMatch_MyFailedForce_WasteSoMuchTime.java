package com.leet.string;

import org.junit.Assert;

/**
 * 10. 正则表达式匹配
 * '.' 匹配任意单个字符
 * '*' 表示[零个]或多个
 */
public class IsMatch_MyFailedForce_WasteSoMuchTime {
    public boolean isMatch(String s, String p) {
        if(s == null) {
            return false;
        }
        if (s.isEmpty()) {
            // 如 "" "c*"
            char[] rep = p.replace(".*", "").toCharArray();

            if (rep.length % 2 != 0) {
                return false;
            }

            for (int i = 1; i < rep.length; i+=2) {
                if (rep[i] != '*') {
                    return false;
                }
            }
            return true;
        }
        char[] chars = s.toCharArray();
        char[] pattern = p.toCharArray();
        boolean isStar = false;
        char star = '*';
        for (int i = 0; i < chars.length; i++) {

            // 当前没有 * 才更新
            if (!isStar) {
                isStar = isStar(pattern, i);
                if (isStar) {
                    star = pattern[i];
                }
            }
            // 没有 *
            if (!isStar) {
                // pattern已经匹配完
                if (i == pattern.length) {
                    return false;
                }
                // chars已匹配完, pattern还有
                if (i == chars.length - 1 && i != pattern.length - 1) {
                    // 如 a ab*
                    while (i + 2 < pattern.length && pattern[i + 2] == '*') {
                        i += 2;
                    }
                    return i == pattern.length - 1;
                }
                // pattern不为 . 且 对应的值不相等
                if (pattern[i] != '.' && chars[i] != pattern[i]) {
                    return false;
                }
            } else { // 有 *
                // star不为 . 且 当前值 和 * 代表的值不同时
                if (star != '.') {
                    if (chars[i] != star) {
                        // 判断是否 * 可表示 0 个
                        if (i + 2 < pattern.length && chars[i] == pattern[i + 2]) {
                            // 可将当前字符及后面的*从pattern中移除
                            pattern = removeCharAt(p, i, i + 1).toCharArray();
                        } else if (i + 1 < pattern.length && chars[i] == pattern[i + 1]) {
                            // 可将当前的*从pattern中移除
                            pattern = removeCharAt(p, i, i).toCharArray();
                        } else {
                            return false;
                        }

                    }
                    isStar = isStar(pattern, i);
                    if (isStar) {
                        star = pattern[i];
                    }
                    if (pattern[i] == '*') {
                        isStar = false;
                    }
                } else { // star 为.
                    if (i < pattern.length - 1 && pattern[i] == '*') {
                        boolean hasEquals = false;
                        int j = chars.length - 1;
                        // 从后向前遍历chars, 移除chars中.*能够代表的字符
                        while (j >= i) {
                            if (chars[j] == pattern[i + 1]) {
                                chars = removeCharAt(s, i - 1, j).toCharArray();
                                pattern = removeCharAt(p, i - 1, i).toCharArray();
                                hasEquals = true;
                                break;
                            }
                            j--;
                        }
                        // 若无.*能够代替的字符, 则pattern移除.*
                        if (!hasEquals) { // 如 ab a.*c
                            pattern = removeCharAt(p, i - 1, i).toCharArray();
                            i = i - 2;
                            isStar = false;
                            continue;
//                            return false;
                        }
                        isStar = false;
                    }

                    // chars匹配完, pattern还有
                    if (i == chars.length - 1  && i < pattern.length - 1) {
                        // 如 a .*..a  a .*.
                        int k = i + 2;
                        while (k < pattern.length - 1 && pattern[k] == '.' && pattern[k + 1] == '*') {
                            k += 2;
                        }
                        if (k == pattern.length - 1 && pattern[k] == '.') {
                            return true;
                        }
                        return k == pattern.length || chars[i] == pattern[k];
                    }

                }

            }

        }

        return true;
    }

    private static String removeCharAt(String s, int start, int end) {
        return s.substring(0, start) + s.substring(end + 1);
    }

    private static boolean isStar(char[] pattern, int i) {
        if (i < pattern.length - 1 && pattern[i + 1] == '*') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        IsMatch_MyFailedForce_WasteSoMuchTime res = new IsMatch_MyFailedForce_WasteSoMuchTime();
        boolean match = res.isMatch("aab", "c*a*b");
        boolean match2 = res.isMatch("aa", "a*");
        boolean match3 = res.isMatch("ab", ".*c");
        boolean match4 = res.isMatch("abasda", ".*a");
        boolean match5 = res.isMatch("mississippi", "mis*is*p*.");
        boolean match6 = res.isMatch("aaa", "aaaa");
        boolean match7 = res.isMatch("aaca", "ab*a*c*a");
        boolean match8 = res.isMatch("aaa", ".*");

        boolean match9 = res.isMatch("a", "ab*");
        boolean match10 = res.isMatch("a", "ab*a");

        boolean match11 = res.isMatch("a", ".*..a");
        boolean match12 = res.isMatch("a", ".*");

        boolean match13 = res.isMatch("ab", ".*..");
        boolean match14 = res.isMatch("a", ".*.");

        boolean match15 = res.isMatch("", ".*");
        boolean match16 = res.isMatch("", ".");

        // 当 b* 为 0 个元素时成立 判断失败
        boolean match17 = res.isMatch("abbbcd", "ab*bbbcd");
        Assert.assertTrue(match);
        Assert.assertTrue(match2);
        Assert.assertFalse(match3);
        Assert.assertTrue(match4);
        Assert.assertFalse(match5);
        Assert.assertFalse(match6);
        Assert.assertTrue(match7);
        Assert.assertTrue(match8);
        Assert.assertTrue(match9);
        Assert.assertFalse(match10);
        Assert.assertFalse(match11);
        Assert.assertTrue(match12);
        Assert.assertTrue(match13);
        Assert.assertTrue(match14);
        Assert.assertTrue(match15);
        Assert.assertFalse(match16);
        Assert.assertTrue(match17);

        System.out.println(match);
        System.out.println(match2);
        System.out.println(match3);
        System.out.println(match4);
        System.out.println(match5);
        System.out.println(match6);
        System.out.println(match7);
        System.out.println(match8);
        System.out.println(match9);
        System.out.println(match10);
        System.out.println(match11);
        System.out.println(match12);
        System.out.println(match13);
        System.out.println(match14);
        System.out.println(match15);
        System.out.println(match16);
        System.out.println(match17);

//        String s = "c*a*b";
//        System.out.println(removeCharAt(s, 0, 1));
    }
}
