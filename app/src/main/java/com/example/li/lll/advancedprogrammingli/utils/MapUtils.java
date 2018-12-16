package com.example.li.lll.advancedprogrammingli.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MapUtils {


    public void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        // put值
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");

        //最简洁、最通用的遍历方式
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        //Java5之前的比较简洁的便利方式1
        System.out.println("----1----");
        for (Iterator<Map.Entry<String, String>> it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        //Java5之前的比较简洁的便利方式2
        System.out.println("----2----");
        for (Iterator<String> it = map.keySet().iterator(); it.hasNext(); ) {
            String key = it.next();
            System.out.println(key + " = " + map.get(key));
        }
    }

    public class TestQueue {
        public  void main(String[] args) {
            Queue<Integer> q = new LinkedBlockingQueue<Integer>();
            //初始化队列
            for (int i = 0; i < 5; i++) {
                q.offer(i);
            }
            System.out.println("-------1-----");
            //集合方式遍历，元素不会被移除
            for (Integer x : q) {
                System.out.println(x);
            }
            System.out.println("-------2-----");
            //队列方式遍历，元素逐个被移除
            while (q.peek() != null) {
                System.out.println(q.poll());
            }
        }
    }

}
