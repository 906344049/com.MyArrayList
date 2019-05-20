package MyMapExe;

//若是自己手写的链表有一个方法可以通过Object来get也可以用自己的包

import java.util.LinkedList;
import java.util.Objects;

/**
 * 001存在问题：
 *          效率较低
 * 002：提高查询的效率
 *      减少循环遍历
 *
 *      Map底层实现 ： 数组 +  链表
 *
 *      取余 重复之后 第二个数组里面每个下标都有链表对象，
 *      链表对象里面存放key - value
 *
 *      同余数的是同一个链表，访问同余数的就遍历链表
 *
 *      如果两个对象equals返回true那么这两个对象的hashcode相同
 *
 */
public class HLSMap002 {
    LinkedList[] array = new LinkedList[100]; //map的底层结构就是数组加链表
    int size;

    public void put(Object key,Object value){
        //根据每个对象的地址生成的一个哈希码，每个对象的地址不同，每个哈希码也不同
//        System.out.println(key.hashCode());
        HLSEntry hlsEntry = new HLSEntry(key,value);
        //取余数有可能是负数，取绝对值
        int i = Math.abs(key.hashCode()%array.length);
        if (array[i]==null){
            LinkedList m = new LinkedList();
            array[i] = m;
            m.add(hlsEntry);
        }else {
            for (int j=0;j<array.length;j++){
                if (((HLSEntry) array[i].get(j)).key.equals(key)){
                    ((HLSEntry) array[i].get(j)).value = value;//键值重复，直接覆盖
                    return;
                }
            }
            array[i].add(hlsEntry);
        }
    }

    public Object get(Object key){
        int i = Math.abs(key.hashCode()%array.length);
        if (array[i]!=null){
            for (int j=0;j<array.length;j++){
                /*HLSEntry temp = (HLSEntry) array[i].get(j);    //取出来方便写
                if (temp.key.equals(key)){
                    return temp.value
                }*/
                if (((HLSEntry) array[i].get(j)).key.equals(key)){
                    return ((HLSEntry) array[i].get(j)).value;
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HLSMap002 m = new HLSMap002();
        m.put("hls","huangleshu");
        m.put("huang213456",new wife("123456"));
        m.put("hls","123456789");
        System.out.println(m.get("hls"));
        System.out.println(((wife)m.get("huang213456")).name);
    }
}
class student extends Object{
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
