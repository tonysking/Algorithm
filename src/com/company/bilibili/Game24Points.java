package com.company.bilibili;

/**
 * 4个1~10数字，得到24胜利
 */
public class Game24Points {
    int res = 0;
    boolean has24 = false;
    public boolean Game24Points (int[] arr) {
        // write code here
        dfs(arr, 0, 0);
        return has24;
    }

    public void dfs(int[] arr, int index, int curRes) {
        if(index == arr.length) {
            if(curRes == 24) {
                res++;
                has24 = true;
            }
            return;
        }

        if(!has24) {
            dfs(arr, index + 1, curRes + arr[index]);
            dfs(arr, index + 1, curRes - arr[index]);
            dfs(arr, index + 1, curRes * arr[index]);
            dfs(arr, index + 1, curRes / arr[index]);
        }

    }
}
