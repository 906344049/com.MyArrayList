package MyMapExe;


import java.util.HashMap;
import java.util.Map;

/**
 * 测试map的基本用法
 *
 * HashMap 效率高 线程不安全
 * HashTable 效率低 线程安全
 *
 */
public class MyMap {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(new Integer(123456),new wife("lala"));
        map.put("hls",new wife("kkk"));
        //wife w = (wife) map.get("hls");
        //System.out.println(w.name);
        wife w = (wife)map.get(123456);
        System.out.println(w.name);
        System.out.println(map.containsKey(123456));
        map.remove(123456);         //在hashMap里面把地址移出去了，并没有删除
        System.out.println(w.name);
        //remove 移除 一整对  键值对
        System.out.println(map.containsKey(123456));
        map.clear();
    }
}

class wife{
    String name;
    public int tele;
    public  wife(String name){
        this.name = name;
    }
}
