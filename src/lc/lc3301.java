package lc;

import java.util.Arrays;

public class lc3301 {
    public static long maximumTotalSum(int[] maximumHeight) {
        if (maximumHeight.length == 1) return maximumHeight[0];
        Arrays.sort(maximumHeight);
        long ans = 0;
        int r = maximumHeight.length - 1;
        int l = r - 1;
        int low = maximumHeight[r];
        while (l >= 0) {
            if (maximumHeight[l] != maximumHeight[r] || l == 0) {
                if (l == 0 && maximumHeight[l] == maximumHeight[r]) {
                    int num = r - l + 1;
                    ans += low * num - num * (num - 1) / 2;
                    low = Math.min(maximumHeight[l],low - num);
                    if (low < 0) return -1;
                } else if (l == 0 && maximumHeight[l] != maximumHeight[r]) {
                    int num = r - l;
                    ans += low * num - num * (num - 1) / 2;
                    low = Math.min(maximumHeight[l],low - num);
                    if (low <= 0) return -1;
                    ans += low;
                } else {
                    int num = r - l;
                    ans += low * num - num * (num - 1) / 2;
                    low = Math.min(maximumHeight[l],low - num);
                    if (low <= 0) return -1;
                    r = l;
                }
            }
            l--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumTotalSum(new int[]{2,3,5,4,2}));
    }
}
