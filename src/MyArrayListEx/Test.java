package MyArrayListEx;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add("huangleshu");
        myArrayList.add("huangleshu1");
        myArrayList.add("huangleshu2");
        for (int i = 3;i<20;i++){
            myArrayList.add("huangleshu" + i);
        }
        System.out.println(myArrayList.get(19));
    }
}





/*myArrayList.add(1);
        myArrayList.add(222);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add("黄乐枢");
        myArrayList.add("huangleshu");
        myArrayList.GetSize();
        myArrayList.remove(0);
        //Integer ob = new Integer(222);
        //myArrayList.remove(new Integer(222));
        myArrayList.set(0,123);
        myArrayList.remove("huangleshu");
        System.out.println(myArrayList.get(0));
        System.out.println(myArrayList.get(3));
        System.out.println(myArrayList.get(4));
        System.out.println(myArrayList.get(5));
//        System.out.println(myArrayList.get(4));
//        System.out.println(myArrayList.get(10));    测试越界之后的异常*/