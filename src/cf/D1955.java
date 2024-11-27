package cf;

import java.util.HashMap;
import java.util.Scanner;

public class D1955 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[] a = new int[n];
            HashMap<Integer, Integer> b = new HashMap<>();
            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < m; i++) {
                int x = in.nextInt();
                b.merge(x, 1, Integer::sum);
            }
            int ans = 0;
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                if (b.getOrDefault(a[i], 0) >= 1) cnt++;
                b.merge(a[i], -1, Integer::sum);
            }
            if (cnt >= k) ans++;
            for (int i = m; i < n; i++) {
                if (b.getOrDefault(a[i], 0) >= 1) cnt++;
                b.merge(a[i], -1, Integer::sum);
                if (b.get(a[i - m]) >= 0) cnt--;
                b.merge(a[i - m], 1, Integer::sum);
                if (cnt >= k) ans++;
            }
            System.out.println(ans);
        }
    }
}

//1 0 1 0 1 1 4 1 5 0 1 0 0 0 0 0 1 0 1 0 2 3 0 1 1 0 0 1 3 0 1 2 2 0 3 1 0 0 2 2 0 0 1 3 0 0 0 2 1 2 1 0 0 1 2 0 0 0 2 1 3 0 0 1 0 0 0 1 3 0 1 1 0 3 4 1 0 1 1 1 1 3 0 0 1 2 0 0 2 2 2 0 1 0 1 1 4 0 0 1 2 4 0 2 0 0 2 3 0 1 0 1 1 1 1 1 0 2 1 1 3 1 1 0 2 1 1 0 0 0 1 1 2 0 1 0 3 1 1 0 0 0 1 3 3 0 1 1 1 0 1 2 3 2 2 1 0 1 2 1 0 4 3 0 0 2 0 0 0 0
//1 0 1 0 1 1 4 1 5 0 1 0 0 0 0 0 1 0 1 0 2 3 0 1 1 0 0 1 3 0 1 2 2 0 3 1 0 1 2 2 0 0 1 3 0 0 1 2 1 2 1 0 0 1 2 0 0 1 2 1 3 0 0 1 0 0 0 1 3 0 1 1 0 3 4 1 0 1 1 1 1 3 0 0 1 2 0 0 2 2 2 0 1 0 1 1 4 0 0 1 2 4 0 2 0 0 2 3 0 1 0 1 1 1 1 1 0 2 1 1 3 1 1 0 2 1 1 1 0 0 1 1 2 0 1 0 3 1 1 0 0 0 1 3 3 0 1 1 1 0 1 2 3 2 2 1 0 1 2 1 0 4 3 0 0 2 0 0 0 0
