package lc;

import java.util.PriorityQueue;

public class LCP24 {

    private static final int MOD = (int) 1e9 + 7;

    public static int[] numsGame(int[] nums) {
        int[] ans = new int[nums.length];
        PriorityQueue<Integer> l = new PriorityQueue<Integer>((a, b) -> b - a);
        PriorityQueue<Integer> r = new PriorityQueue<Integer>();
        long sumL = nums[0], sumR = 0;
        l.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            l.add(nums[i]);
            sumR += nums[i];
            if (l.size() > r.size()) {
                r.add(l.poll());
                sumR -= nums[l.size() + 1];
                sumL += nums[l.size() + 1];
            }
            long mid = 0;
            if (r.size() == l.size()) mid = (l.peek() + r.peek() + 1) / 2;
            else mid = r.peek();
            int res = (int) (Math.abs(l.size() * (mid - 1) - sumL - (l.size() * (l.size() - 1)) / 2) % MOD);
            if (r.peek() == mid) {
                res = (int) ((res + Math.abs(sumR - r.size() * mid - (r.size() * (r.size() - 1)) / 2) % MOD) % MOD);
            } else {
                res += (int) ((res + Math.abs(sumR - r.size() * mid - (r.size() * (r.size() + 1)) / 2) % MOD) % MOD);
            }
            ans[i] = res;
        }
        return ans;
    }

    public static void main(String[] args) {
        numsGame(new int[] {3,4,5,1,6,7});
    }
}
