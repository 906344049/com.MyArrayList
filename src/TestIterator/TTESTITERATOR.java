package TestIterator;

import java.util.*;

/**
 * 迭代器遍历ArrayList Set
 * Map（两种方法：）
 */

/*
        虽然使用    keyset   及    entryset   来进行遍历Map能取得相同的结果，但两者的遍历速度是有差别的。

        keySet():      迭代后只能通过get()取key；再根据key值取value。     map.get(key);

        entrySet()：迭代后可以e.getKey()，e.getValue()取key和value。      用一个与Map相同映射关系（泛型相同，类型相同）的对象接收lter.next()后直接可以   .getKey();  .getValue();

        同时，keySet()的速度比entrySet()慢了很多，也就是keySet方式遍历Map的性能不如entrySet性能好

        为了提高性能，以后   /**多考虑用    entrySet()     d方式****//*来进行遍历。

        ---------------------
 */
public class TTESTITERATOR {
    public static void main(String[] args) {
        test();
        testSet();
        testMap();
        testMap1();
    }
    public static void testMap1(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"huangleshu");
        map.put(2,"huangleshu1");
        map.put(3,"huangleshu2");
        Set<Integer>set = map.keySet();
        for (Iterator<Integer> iterator = set.iterator();iterator.hasNext();){
            Integer key = iterator.next();
            System.out.println(key+"--"+map.get(key));
        }
    }
    public static void testMap(){
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(1,"aa");
        map1.put(2,"bb");
        map1.put(3,"cc");
        Set<Map.Entry<Integer,String>> ss = map1.entrySet();
        for (Iterator<Map.Entry<Integer,String>> iter = ss.iterator();iter.hasNext();){
            Map.Entry<Integer,String> temp =  iter.next();
            System.out.println(temp.getKey()+"____"+temp.getValue());
        }
    }
    public static void testSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        for (Iterator<String> iter =  set.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }
    public static void test(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println(list.size());
        for (Iterator<String> iter =  list.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

}
