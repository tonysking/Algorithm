package com.company.bilibili;


import org.junit.Assert;

/**
 * 面值1元、4元、16元、64元共计4中硬币
 * 面值1024元纸币
 *
 * 用1024纸币购买了一件价值位N(0 <= N <= 1024)的商品，最少会收到多少硬币
 */
public class GetCoinCount {
    /**
     *
     * @param N int整型
     * @return int整型
     */
    private int min = 1024;
    public int GetCoinCount (int N) {
        // write code here
        if(N == 1024 || N == 0) {
            return 0;
        }
        int res = 1024 - N;
        dfs(res, 0);
        return min;
    }

    public void dfs(int res, int curCoin) {
        if(res < 0) {
            return;
        }
        if(res == 0) {
            min = Math.min(min, curCoin);
            return;
        }
        int coin64 = res / 64;
        int coin16 = res / 16;
        int coin4 = res / 4;
        int coin1 = res;
        if(coin64 > 0) {
            dfs(res - coin64 * 64, curCoin + coin64);
        }
        if(coin16 > 0) {
            dfs(res - coin16 * 16, curCoin + coin16);
        }
        if(coin4 > 0) {
            dfs(res - coin4 * 4, curCoin + coin4);
        }
        if(coin1 > 0) {
            dfs(res - coin1, curCoin + coin1);
        }

    }

    public static void main(String[] args) {
        GetCoinCount res = new GetCoinCount();
        int count = res.GetCoinCount(200);
        System.out.println(count);
        Assert.assertEquals(17, count);
    }
}
