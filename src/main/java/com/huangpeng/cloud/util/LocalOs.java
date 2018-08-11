package com.huangpeng.cloud.util;

/**
 * <pre>
 * 任务：
 * 描述：
 * 作者：@author huangpeng
 * 时间：@create 2018-07-11 下午2:51
 * 类名: LocalOs
 * </pre>
 **/

public class LocalOs {
    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) throws InterruptedException {

        String s0 = new StringBuilder().append(22).toString();
        System.out.println(s0);
//
//        String s1 = new StringBuilder().append("ja").append("va").toString();
//        System.out.println(s1.intern() == s1);

    }


//        Thread t1 = new Thread(()->{
//            System.out.println("t1");
//        });
//        Thread t2 = new Thread(()->{
//            System.out.println("t2");
//        });
//        Thread t3 = new Thread(()->{
//            System.out.println("t3");
//        });
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();
//        t3.start();
//        t3.join();


//        String os = System.getProperty("os.name");
//        System.out.println(os);
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("1","huangpeng");
//        map.put("2","kk");
//        String s = "666";
//        System.out.println(s.hashCode());
}
