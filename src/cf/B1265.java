package cf;

import java.util.HashMap;
import java.util.Scanner;

public class B1265 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int key = in.nextInt();
                map.put(key,i);
            }
            int max = 0, min = Integer.MAX_VALUE;
            for (int key = 1; key <= n; key++) {
                max = Math.max(max, map.get(key));
                min = Math.min(min, map.get(key));
                if (max - min + 1 == key) System.out.print(1);
                else System.out.print(0);
            }
            System.out.println();
        }
    }
}
