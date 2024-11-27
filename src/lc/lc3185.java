//public class lc3185 {
//
//    public static long countCompleteDayPairs(int[] hours) {
//        long ans = 0;
//        HashMap<Integer, Integer> cnt = new HashMap<Integer, Integer>();
//        for (int hour : hours) cnt.merge(hour % 24, 1, Integer::sum);
//        for (int i = 0; i < hours.length - 1; i++) {
//            cnt.merge(hours[i] % 24, -1, Integer::sum);
//            ans += cnt.getOrDefault((24 - (hours[i] % 24)) % 24, 0);
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        System.out.printf("", countCompleteDayPairs(new int[]{12, 12, 30, 24, 24}));
//    }
//}
