package lc;

import java.io.IOException;
import java.util.HashMap;

public class Test1 {

    /**
     * 这个map 桶的长度为2，当元素个数达到  2 * 1.5 = 3 的时候才会触发扩容
     */
    private static HashMap<Integer,String> map = new HashMap<Integer,String>(2,1.5f);

    public static void main(String[] args) throws IOException, InterruptedException {
        map.put(5,"5");
        map.put(7,"7");
        map.put(3,"3");
        System.out.println("此时元素已经达到3了，再往里面添加就会产生扩容操作：" + map);
        new Thread("T1") {
            public void run() {
                map.put(11, "11");
                System.out.println(Thread.currentThread().getName() + "扩容完毕 " );
            };
        }.start();
        new Thread("T2") {
            public void run() {
                map.put(15, "15");
                System.out.println(Thread.currentThread().getName() + "扩容完毕 " + map);
            };
        }.start();

        Thread.sleep(30000);//时间根据debug时间调整

        //死循环后打印直接OOM，思考一下为什么？
        //因为打印的时候回调用toString回遍历链表，但此时链表已经成环状了
        //那么就会无限拼接字符串
//        System.out.println(map);
        System.out.println(map.get(5));
        System.out.println(map.get(7));
        System.out.println(map.get(3));
        System.out.println(map.get(11));
        System.out.println(map.get(15));

    }
}


