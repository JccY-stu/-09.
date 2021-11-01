import org.omg.CORBA.Object;

/**
 * @Author Chengzhi
 * @Date 2021/10/30 0:41
 * @Version 1.0
 */
public class CirculateQueue<T> {
    // 数组：items，数组大小：n
    private T[] items;
    // 队列容量
    private int capacity;
    // head表示队头下标，tail表示队尾下标
    private int head;
    private int tail;

    // 申请一个大小为capacity的数组
    public CirculateQueue(int capacity) {
        items = (T[])new Object[capacity];
        this.capacity = capacity;
        head = 0;
        tail = 0;
    }

    // 入队
    public boolean enqueue(T item) throws Exception {
        // 队列满了
        if ((tail + 1) % capacity == head) {
            throw new Exception("队列已经满了");
        }
        //队列还没满
        items[tail] = item;
        tail = (tail + 1) % capacity;
        return true;
    }

    // 出队
    public T dequeue() throws Exception {
        // 如果head == tail 表示队列为空
        if (head == tail){
            throw new Exception("队列为空！");
        }
        // 队列不为空
        T result = items[head];
        head = (head + 1) % capacity;
        return result;
    }
}
