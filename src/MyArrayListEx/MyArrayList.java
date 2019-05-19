package MyArrayListEx;


public class MyArrayList {
    private Object[] objArray;
    private int size;
    public void GetSize(){
        System.out.println(size);
    }
    public MyArrayList(){
        this(10);
    }

    /**
     *
     * @param initialCapacity 对象数组的大小，即MyArrayList的大小
     */
    public MyArrayList(int initialCapacity){
        if (initialCapacity<0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        objArray = new Object[initialCapacity];
    }

    public void add(Object ob){
        //数组扩容
        ensureCapacity();
        objArray[size] = ob;
        size++;
    }
    public void add(int index,Object obj){
        rangeCheck(index);
        ensureCapacity();
        System.arraycopy(objArray,index,objArray,index+1,size-index);
        objArray[index] = obj;
    }
    public Object get(int index){
        rangeCheck(index);
        return objArray[index];
    }
    public void remove(int index){
        rangeCheck(index);
        rangeCheck(index);
        int numMove = size-index-1;
        if (numMove>0)
        System.arraycopy(objArray,index+1,objArray,index,size-index-1);
        objArray[--size] = null;
    }
    public boolean remove(Object obj){
        for (int i=0;i<size;i++){
            if (objArray[i].equals(obj)){
                remove(i);
                return true;
            }
        }
        return false;
    }
    public void set(int index,Object obj){
        rangeCheck(index);
        objArray[index] = obj;
    }
    private void ensureCapacity(){
        if (size>=objArray.length){
            Object[] NewArray = new Object[size*2];
            System.arraycopy(objArray,0,NewArray,0,objArray.length);
//            for (int i=0;i<objArray.length;i++){
//                NewArray[i] = objArray[i];
//            }
            objArray = NewArray;
        }
    }
    private void rangeCheck(int index){
        if (index>=size){      //size肯定大于0
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

