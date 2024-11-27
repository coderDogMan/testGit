package lc;

import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int findPaiIdx(List<Integer> paiList, Integer pai) {
        // 二分查找
        int l = 0, r = paiList.size() - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (paiList.get(mid) >= pai) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(3);
        list.add(4);
        System.out.println(findPaiIdx(list, 5));
    }

}