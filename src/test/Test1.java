package test;

import java.util.TreeMap;

public class Test1 {
    public static void main(String[] args) {
        TreeMap map = new TreeMap<Integer, Integer>();
        map.put(1,1);
        map.put(2,1);
        map.put(3,1);
        map.put(4,1);
        map.put(5,1);
        for (Object o : map.keySet()) {
            System.out.println(o);
        }


    }
}
