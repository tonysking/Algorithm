package com.leet.dp;


/**
 * 518. 零钱兑换 II
 */
public class Change {
    // 递归（计算组合)
    private int[][] map;
    public int change(int amount, int[] coins) {

        map = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                map[i][j] = -1;
            }
        }
        return changeR(amount, coins, 0);
    }

    public int changeR(int amount, int[] coins, int start) {
        int sum = 0;
        if(amount == 0) {
            return 1;
        }
        for(int i = start; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                if(map[i][amount - coins[i]] == -1) {
                    map[i][amount - coins[i]] = changeR(amount - coins[i], coins, i);
                }
                sum += map[i][amount - coins[i]];
            }
        }
        return sum;
    }

    // dp
    public int changeDP(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                // 注意
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }

        return dp[n][amount];
    }

    // dp空间优化
    public int changeDP2(int amount, int[] coins) {
        int[] dp = new int[amount + 1];

        dp[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] += dp[j - coin];
            }
        }

        return dp[amount];
    }
}
