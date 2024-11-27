package cf;

import java.util.Arrays;
import java.util.Scanner;

public class C1940 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            long[] nums = new long[n];
            for (int i = 0; i < n; i++) nums[i] = in.nextLong();
            if (k >= 3) {
                System.out.println(0);
            } else {
                Arrays.sort(nums);
                long ans = nums[0];
                for (int i = 1; i < n; i++) ans = Math.min(ans, Math.min(nums[i], nums[i] - nums[i - 1]));
                if (k == 1) {
                    System.out.println(ans);
                } else {
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            long d = nums[j] - nums[i];
                            int idx = find(nums, d);
                            if (idx < n) ans = Math.min(ans, nums[idx] - d);
                            if (idx > 0) ans = Math.min(ans, d - nums[idx - 1]);
                        }
                    }
                    System.out.println(ans);
                }
            }
        }

    }

    private static int find(long[] nums, long d) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= d) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

}
