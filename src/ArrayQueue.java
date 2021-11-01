

/**
 * @Author Chengzhi
 * @Date 2021/10/29 22:10
 * @Version 1.0
 *
 *  * 通过数组 实现一个队列
 *  *
 *  * 数据操作：
 *  *  1.构造队列
 *  *  2.判断队列是否为空
 *  *  3.向队列的队尾插入一个元素
 *  *  4.获得队头元素
 *  *  5.获得队尾元素
 *  *  6.从队列的队头移除一个元素
 */
public class ArrayQueue<T>{
    private T[] items;//不知道队列存储什么数据类型，使用泛型
    private int size;//栈中元素的个数
    private int capciaty;//队列容量
    //队头下标，队尾下标
    private int head;
    private int tail;

    //构造函数
    public ArrayQueue(int capacity){
        //申请一个大小为capacity的数组
         items =  (T[])new Object[capacity];
         this.capciaty = capacity;
         head = 0;
         tail = 0;
    }

    //入队
    public boolean enqueue(T item) throws Exception {
        //如果tail == capacity 则表示队列已满
        if(tail == capciaty){
            if(head == 0) {
                throw new Exception("队列已经满了，放不下了");
            }
            //否则head下标前面的空间是空闲的，可以通过数据迁移继续使用
            for(int i = head ; i < tail  ; i++){
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }
        //插入元素
        items[tail] = item;
        //移动尾标
        tail++;
        size++;
        return true;
    }

    //出队
    //不停地进行入队、出队操作，head和tail都会持续往后移动，当tail移动到最右边，即使数组中还有空闲空间，也无法继续往队列中添加数据
    //可以用数据搬移，优化到入队时集中触发一次数据的搬移操作即可
    public T dequeue() throws Exception{
        //出队要判断队列是否为空
        if(head == tail) {
            throw new Exception("队列为空！");
        }
        //队列不为空，移动头标
        T result = items[head];
        head++;
        size--;
        return result;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return head == tail;
    }

    //返回队列大小（元素个数）
    public int size(){
        return size;
    }

    //获得队头元素
    public T getHead(){
        return items[head];
    }

    //获得队尾元素
    public T getTail(){
        return items[tail - 1];
    }
}

class Test{
    public static void main(String[] args) throws Exception {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(3);
        arrayQueue.enqueue(5);
        System.out.println("出队元素为：" + arrayQueue.dequeue());
        System.out.println("队头元素为：" + arrayQueue.getHead());
        System.out.println("队尾元素为：" + arrayQueue.getTail());
    }
}
