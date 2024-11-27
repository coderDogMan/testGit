package lc;

import java.util.Arrays;

public class Test2 {
    int n;
    int[] re;
    int[][] memo;

    public int maxTotalReward(int[] rewardValues) {
        n= rewardValues.length;
        this.re = rewardValues;
        memo = new int[4020][4020];
        for(int[]ints :memo) {
            Arrays.fill(ints,-1);
        }
        Arrays.sort(re);
        return dfs(0, 0);
    }

    private int dfs(int i, int sum) {
        if (i == n) return sum;
        if (memo[i][sum] != -1) return sum + memo[i][sum];
        int res = dfs(i + 1, sum);
        if (re[i] > sum) res = Math.max(res, dfs(i + 1, sum + re[i]));
        return memo[i][sum] = res - sum;
    }
}
