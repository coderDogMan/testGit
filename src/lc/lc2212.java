package lc;

import java.util.LinkedList;

public class lc2212 {

    int[] ans = new int[12];
    int max = 0;
    int[] aliceArrows;
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        this.aliceArrows = aliceArrows;
        dfs(numArrows, 1, new int[12] );
        return ans;
    }

    private void dfs(int k, int i, int[] cur) {
        if (k < 0) return;
        if (i == aliceArrows.length) {
            int sum = getSum(cur, aliceArrows);
            if (sum > max) {
                max = sum;
                ans = cur.clone();
            }
            return;
        }
        // 选
        cur[i] =  aliceArrows[i] + 1;
        dfs(k - cur[i], i + 1, cur);
        //不选
        cur[i] = 0;
        dfs(k, i + 1, cur);

    }

    private int getSum(int[] cur, int[] aliceArrows) {
        int sum = 0;
        for (int i = 1; i <= 11; i++) if (cur[i] > aliceArrows[i]) sum += i;
        return sum;
    }

}
