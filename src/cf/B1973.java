//package cf;
//
//import java.util.Scanner;
//
//public class B1973 {
//
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int T = in.nextInt();
//        while (T-- > 0) {
//            int n = in.nextInt();
//            int[] a = new int[n];
//            for (int i = 0; i < n; i++) a[i] = in.nextInt();
//            System.out.println(find(a));
//        }
//    }
//
//    private static int find(int[] a) {
//        int l = 1, r = a.length;
//        while (l <= r) {
//            int mid = l + (r - l) / 2;
//            if (check(a, mid)) {
//                r = mid - 1;
//            } else {
//                l = mid + 1;
//            }
//        }
//        return l;
//
//    }
//
//    private static boolean check(int[] a, int k) {
//        int or = 0;
//        for (int i = 0; i < k; i++) or |= a[i];
//        for (int i = k; i < a.length; i++) {
//            int temp = or;
//            or
//            or |= a[i];
//            if (temp != or) return false;
//        }
//        return true;
//    }
//}
