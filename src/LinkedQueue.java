/**
 * @Author Chengzhi
 * @Date 2021/10/30 0:04
 * @Version 1.0
 *
 *  * 通过链表 实现一个队列
 *  *
 *  * 数据操作：
 *  *  1.构造队列
 *  *  2.判断队列是否为空
 *  *  3.向队列的队尾插入一个元素
 *  *  4.获得队头元素
 *  *  5.获得队尾元素
 *  *  6.从队列的队头移除一个元素
 */
public class LinkedQueue<T> {
    //定义链表结点
    public class Node<T> {
        private T data;
        private Node next;

        public Node(T element,Node next){
            this.data = element;
            this.next = next;
        }

        public T getData(){
            return data;
        }
    }

    //队列的队首和队尾
    private Node head;
    private Node tail;

    //构造函数 初始化队列队头和队尾指向
    public LinkedQueue(){
        head = null;
        tail = null;
    }

    //入队
    public void enqueue(T item){
        //入队判断队列是否已经有了元素
        if(tail == null){
            //创建第一个元素（特殊情况）
            Node newNode = new Node(item,null);
            head = newNode;
            tail = newNode;
        }else{
            //入队，只移动 tail
            Node newNode = new Node(item,null);
            tail.next = newNode;
            tail = tail.next;
        }
    }

    //出队
    public T dequeue() throws Exception {
        //是否判断队列是否为空
        if(head == null){
            throw new Exception("队列为空！无法出队");
        }
        //队列不为空，移动head
        T result = (T) head.data;
        head = head.next;
        if(head == null){//如果head == null 代表队列为空，已经出完了，则将tail置空
            //当head == tail == null的时候 代表队列为空
            tail = null;
        }
        return result;
    }
}

class TestLinked{
    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(8);
        System.out.println("出队元素为：" + arrayQueue.dequeue());
        System.out.println("队头元素为：" + arrayQueue.getHead());
        System.out.println("队尾元素为：" + arrayQueue.getTail());
    }
}