package com.leet.dp;

/**
 * 面试题46. 把数字翻译成字符串
 * DP:
 * 用 f(i) 表示以第 i位结尾的前缀串翻译的方案数
 * f(i)=f(i−1)+f(i−2)[i−1≥0,10≤x≤25]
 */
public class TranslateNum {


    // dp 空间优化
    public int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        String s = String.valueOf(num);
        int res = 0;
        int pre1 = 1;
        int pre2 = 0;
        for (int i = 1; i < s.length(); i++) {

            // 注意是 = 不是 +=
            res = pre1;
            String trans = s.substring(i - 1, i + 1);
            if (trans.compareTo("25") <= 0 && trans.compareTo("10") >= 0) {
                if (i == 1) {
                    res += 1;
                } else {
                    res += pre2;
                }
            }

            pre2 = pre1;
            pre1 = res;

        }
        return res;
    }

    // dp
    public int translateNumDP1(int num) {
        if (num < 10) {
            return 1;
        }
        String s = String.valueOf(num);
        int[] res = new int[s.length() + 1];
        res[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            res[i] = res[i - 1];
            String trans = s.substring(i - 1, i + 1);
            if (trans.compareTo("25") <= 0 && trans.compareTo("10") >= 0) {
                if (i == 1) { // 第一次特殊情况
                    res[i] += 1;
                } else {
                    res[i] += res[i - 2];
                }
            }

        }
        return res[s.length() - 1];
    }

    // 递归
    public int translateNumR(int num) {
        if (num < 10) {
            return 1;
        }
        int trans = num % 100;
        if (trans <= 25 && trans >= 10) {
            return translateNumR(num / 10) + translateNumR(num / 100);
        } else {
            return translateNumR(num / 10);
        }
    }



    // 失败
    public int translateNumFailed(int num) {
        // num转换为数组
        int length = 0;
        int cur = num;
        while (cur > 0) {
            cur /= 10;
            length++;
        }
        int[] nums = new int[length];
        int i = 0;
        while (num > 0) {
            nums[i++] = num % 10;
            num /= 10;
        }

        // 两两组成数字是否<=25
        int res = 1;
        boolean[] isTrans = new boolean[length];
        for (int j = 0; j < length - 1; j++) {
            int curNum = nums[j] * 10 + nums[j + 1];
            if (curNum <= 25) {
                isTrans[j] = true;
            }
        }

        // 不全面
        for (int j = 0; j < length - 2; j++) {
            if (isTrans[j]) {
                res++;
                for (int k = j + 2; k < length - 1; k++) {
                    if (isTrans[k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TranslateNum res = new TranslateNum();
        int i = res.translateNum(624);
        int i1 = res.translateNumDP1(624);
        System.out.println(i);
        System.out.println(i1);
    }
}
