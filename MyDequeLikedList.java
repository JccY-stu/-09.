/**
 * @Author Chengzhi
 * @Date 2021/11/1 14:05
 * @Version 1.0
 *
 * 双向链表
 */
class MyDequeLinkedList<T> {
    int size;//链表长度
    DequeListNode head;//头节点

        //定义结点
        class DequeListNode<T> {
            DequeListNode pre;
            DequeListNode next;
            int val;
            public DequeListNode(){};
            public DequeListNode(int val) {
                pre = null;
                next = null;
                this.val = val;
            }
        }

        //初始化双向链表
        public MyDequeLinkedList() {
            size = 0;
            head = new DequeListNode();
            head.next = null;
        }

        public int get(int index) {
            if (index >= size || size == 0) {//下标越界或者链表为空
                return -1;
            }
            int i = 0;
            DequeListNode res = head.next;
            while (i != index) {
                res = res.next;
                i++;
            }
            return res.val;
        }

        public void addAtHead(int val) {
            addAtIndex(0,val);
        }

        public void addAtTail(int val) {
            addAtIndex(size,val);
        }

        public void addAtIndex(int index,int val) {
            if(index > size || index < 0){
                return ;
            }
            //创建一个新Node
            DequeListNode<Integer> newNode = new DequeListNode<Integer>(val);
            int i = 0;
            DequeListNode res = head;
            while(i != index){
                res = res.next;
                i++;
            }
            add(res,newNode);
        }

        public void add(DequeListNode res,DequeListNode newNode){
            newNode.pre = res;
            newNode.next = res.next;
            if(res.next != null){
                res.next.pre = newNode;
            }
            res.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size || size == 0) return;
            int i = 0;
            DequeListNode res = head.next;
            while (i != index) {
                res = res.next;
                i++;
            }
            res.pre.next = res.next;
            if (res.next != null) {
                res.next.pre = res.pre;
            }
            res.pre = null;
            res.next = null;
            size--;
        }
    }
class Test01{
    public static void main(String[] args) {
        MyDequeLinkedList myLinkedList = new MyDequeLinkedList();
        myLinkedList.addAtHead(5);
        myLinkedList.addAtIndex(1,15);
        myLinkedList.addAtIndex(2,20);
        myLinkedList.addAtTail(999);
        myLinkedList.deleteAtIndex(0);
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));
        System.out.println(myLinkedList.get(2));
    }
}