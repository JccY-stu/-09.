/**
 * @Author Chengzhi
 * @Date 2021/10/31 16:00
 * @Version 1.0
 *
 * 单链表
 */
public class MyLinkedList {
    class LinkedNode {
        LinkedNode next;
        int val;

        public LinkedNode(int val) {
            this.val = val;
        }
    }

    int size;
    LinkedNode head;

    public MyLinkedList() {
        head = new LinkedNode(-1);
        head.next = null;
        size = 0;
    }

    public int get(int index) {
        if (index >= size || size == 0) {
            return -1;
        }
        int i = 0;
        LinkedNode res = head.next;
        while (i != index) {
            res = res.next;
            i++;
        }
        return res.val;
    }

    //在头部创建结点
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    //在尾部创建结点
    public void addAtTail(int val) {
        addAtIndex(size,val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size || index < 0){
            return ;
        }
        //创建一个新Node
        LinkedNode newNode = new LinkedNode(val);
        int i = 0;
        LinkedNode res = head;
        while(i != index){
            res = res.next;
            i++;
        }
        add(res,newNode);
    }

    public void add(LinkedNode res,LinkedNode newNode){
        LinkedNode next = res.next;
        res.next = null;
        res.next = newNode;
        newNode.next = next;
        size++;
    }

    //删除链表
    public void deleteAtIndex(int index) {
        if(index >= size || size == 0)return ;
        int i = 0;
        LinkedNode res = head;
        while(i != index){
            res = res.next;
            i++;
        }
        LinkedNode next = res.next.next;
        res.next.next = null;
        res.next = next;
        size--;
    }

}

class Test{
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtIndex(0,5);
        myLinkedList.addAtIndex(1,15);
        myLinkedList.addAtHead(20);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        myLinkedList.deleteAtIndex(0);
        myLinkedList.addAtTail(90);
        System.out.println(myLinkedList.get(1));
    }

}