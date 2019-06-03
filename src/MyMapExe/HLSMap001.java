package MyMapExe;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *   自定义实现Map功能！
 *   简单版   暂不完美
 *
 *   存放键值对
 *
 *   根据键对象 找到值对象
 *
 *   键不能重复（重复会覆盖）
 *
 *   问题：每次都要遍历，效率较低
 */
public class HLSMap001 {

    Map test = new ConcurrentHashMap();
    HLSEntry[] array = new HLSEntry[100];
    //不考虑数组扩容，以后可以加上
    int size;

    public void put(Object key,Object value){
        /*
            如果有相等的就抛异常
        boolean check =  containKey(key);
        if (check == true){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/
        //   value覆盖  key不变
        HLSEntry h = new HLSEntry(key, value);
        for(int i=0;i<size;i++){
            if (array[i].key.equals(key)){
                array[i].value = value;
                return;
            }
        }
        array[size++] = h;
    }

    public Object get(Object key){
        for(int i=0;i<size;i++){
            if (array[i].key.equals(key)){
                return array[i].value;
            }
        }
        return null;
    }

    public boolean containKey(Object key){
        for (int i=0;i<size;i++){
            if (array[i].key.equals(key)){
                return true;
            }
        }
        return false;
    }
    public void remove(Object key){
        int temp=1;
        for (int i=0;i<size;i++){
            if (array[i].key.equals(key)){
                array[i] = null;
                System.arraycopy(array,i+1,array,i,size-i-1);
                temp = 0;
            }
        }
        if (temp==1){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        HLSMap001 hlsMap001 = new HLSMap001();
        hlsMap001.put(new Integer(123),new wife("huangleshu"));
        hlsMap001.put(new Integer(123456),new wife("huangleshu1"));
        wife w = (wife) hlsMap001.get(123456);
        System.out.println(w.name);
    }
}

class HLSEntry{
    public Object key;
    public Object value;

    public HLSEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}