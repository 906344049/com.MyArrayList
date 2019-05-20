package MyListEx;

/**
 * @Note 双向链表
 */
public class MList1{
    private Node first;
    private Node last;
    private int size = 0;
    //添加节点
    public void add(Object obj){
        Node n = new Node();

        if (first == null){
            n.setPrevious(null);
            n.setObj(obj);
            n.setNext(null);
            first = n;
            last = n;
        }else {
            //直接在last后加新节点
            n.setPrevious(last);
            n.setObj(obj);
            n.setNext(null);
            last.setNext(n);
            last = n;
        }
        size++;
    }
    public void add(int index,Object obj){
        rangeCheck(index);
        Node newNode = new Node();
        newNode.setObj(obj);
        if (index==0) {
            newNode.setPrevious(null);
            newNode.setNext(first);
            first.setPrevious(newNode);
            first = newNode;
        } else {
            Node temp = null;
            for (int i=0;i<index;i++){
                temp = temp.getNext();
            }
            Node up = temp.getPrevious();
            newNode.setPrevious(up);
            newNode.setNext(temp);
        }
        size++;
    }
    //获取节点储存的对象
    public Object get(int index){
        rangeCheck(index);
        Node temp ;
        if (first==null){
            return null;
        }else {
            temp = first;
            for (int i=0;i<index;i++){
                temp = temp.getNext();
            }
        }
        return temp.getObj();
    }

    //可以补一个通过对象来找到节点的东东

    //移除
    public void remove(int index){
        rangeCheck(index);
        if (index==0){
            first = first.getNext();
            //这里的双向链表要删去表头的时候要不要清空第二个节点的previousNode，虽然没有打印出来
            first.setPrevious(null);
        }else if (index==size-1){
            last = last.getPrevious();
            Node down = last.getPrevious();
            down.setNext(null);
        }else {
            Node temp = null;
            temp = first;
            for (int i=0;i<index;i++){
                temp = temp.getNext();
            }
            Node up = temp.getPrevious();
            Node down = temp.getNext();
            up.setNext(down);
            down.setPrevious(up);
        }
        size--;
    }
    //检验下标的范围
    public void rangeCheck(int index){
        if (index<0 || index>=size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    //获取链表的长度
    public  int size(){
        return size;
    }
    public static void main(String[] args) {
        MList1 list = new MList1();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        list.add("eee");
//        System.out.println(list.get(5));
        list.remove(0);
        System.out.println(list.get(0));
        list.add(0,"aaa1");
        System.out.println(list.get(0));
        list.remove(4);
        System.out.println(list.get(3));
        System.out.println(list.get(4));
    }
}
