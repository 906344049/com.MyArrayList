package MySetTest;

import java.util.Collection;
import java.util.HashMap;

public class HLSMySet{
    HashMap map;
    private static final Object PRESENT = new Object();

    public HLSMySet(){
        map = new HashMap();
    }

    public void add(Object obj){
        map.put(obj,PRESENT);//set 不可重复的本质是map里面的key不可重复
    }
    public int getSize(){
        return map.size();
    }
    public void remove(){

    }

    public static void main(String[] args) {
        HLSMySet s = new HLSMySet();
        s.add("aaa");
        s.add("aaa");
        System.out.println(s.getSize());

    }
}
