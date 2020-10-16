package com;

import java.util.*;

/**
 * 1. 统计每个单词出现的次数
 * 	有如下字符串"If you want to change your life I think you must come to learn English"(用空格间隔)
 * 	打印格式：
 * 	to=3
 * 	think=1
 * 	you=2
 * 2. 将玩家姓名和游戏得分录入系统，输出排名前三的玩家和其得分。
 * 	玩家A：10分，玩家B：40分，玩家C：30分，玩家D：20分，玩家E：50分
 * 3. 如何在字符串中找到第一个不重复的字符(使用Java集合框架)
 * 	字符串： yellow
 * 4. 人事部需对公司员工籍贯进行统计，请输出地区和对应的员工姓名
 * 	Jack：安徽
 * 	Rose：江苏
 * 	Divid：浙江
 * 	Lily：安徽
 * 	Lucy：浙江
 * 	Tom：山东
 */
public class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> wordCount = wordCount("If you want to change your life I think you must come to learn English", " ");
        for (Map.Entry<String, Integer> entry: wordCount.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        treemap();

        Character res = linkedhashmap("yellow");
        System.out.println("第一个不重复的字符: " + res);

        hashmap();
    }


    /**
     * 统计单词出现次数
     * @param str
     * @param regex
     * @return
     */
    public static HashMap<String, Integer> wordCount(String str, String regex) {
        String[] arr = str.split(regex);
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s: arr) {
            if (hashMap.containsKey(s)) {
                int i = hashMap.get(s);
                hashMap.put(s, ++i);
            } else {
                hashMap.put(s, 1);
            }
        }
        return hashMap;
    }


    /**
     * 将玩家姓名和游戏得分录入系统，输出排名前三的玩家和其得分。
     *  玩家A：10分，玩家B：40分，玩家C：30分，玩家D：20分，玩家E：50分
     */
    public static void treemap() {
        TreeMap<Game, Integer> gameIntegerTreeMap = new TreeMap<>();
        Game ga = new Game("A", 10);
        Game gb = new Game("B", 40);
        Game gc = new Game("C", 30);
        Game gd = new Game("D", 20);
        Game ge = new Game("E", 50);

        gameIntegerTreeMap.put(ga, ga.getScore());
        gameIntegerTreeMap.put(gb, gb.getScore());
        gameIntegerTreeMap.put(gc, gc.getScore());
        gameIntegerTreeMap.put(gd, gd.getScore());
        gameIntegerTreeMap.put(ge, ge.getScore());

        int i = 0;
        for (Map.Entry entry: gameIntegerTreeMap.entrySet()) {
            if (i > 2) {
                break;
            }
            System.out.println(entry.getKey() + "=" + entry.getValue());
            ++i;
        }
    }


    public static Character linkedhashmap(String str) {
        Map<Character, Integer> map = new LinkedHashMap<Character,Integer>(str.length());

        for (char c : str.toCharArray()) {
            map.put(c,map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        throw new RuntimeException("没有找到相关的字符");
    }



    /**
     *  人事部需对公司员工籍贯进行统计，请输出地区和对应的员工姓名
     *  Jack：安徽
     *  Rose：江苏
     *  Divid：浙江
     *  Lily：安徽
     *  Lucy：浙江
     *  Tom：山东
     */
    public static void hashmap() {
        HashMap<String, String> hashMap = new HashMap<>();

        hashMap.put("Jack", "安徽");
        hashMap.put("Rose", "江苏");
        hashMap.put("Divid", "浙江");
        hashMap.put("Lily", "安徽");
        hashMap.put("Lucy", "浙江");
        hashMap.put("Tom", "山东");

        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getValue() + "->" + entry.getKey());
        }
    }
}
