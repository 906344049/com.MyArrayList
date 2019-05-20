package MySetTest;

import java.util.HashSet;
import java.util.Set;

/**
 *  set 无序不可重复
 *
 *  测试set常用方法
 *
 *  set 的底层是通过map来实现的
 *
 *  hashset的用法
 */
public class HLSset {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add("aaa");
        set.add("bbb");
        set.add(new String("aaa"));
        //add作为key添加进set里面的map
        System.out.println(set.size());
        System.out.println(set.contains("aaa"));
        set.remove("aaa");
    }
}
