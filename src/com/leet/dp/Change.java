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
}
