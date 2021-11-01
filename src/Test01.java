import java.util.HashMap;
import java.util.Map;

/**
 * @Author Chengzhi
 * @Date 2021/10/30 15:52
 * @Version 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hs = new HashMap<Integer,Integer>();
        hs.put(0,0);
        hs.put(1,2);
        System.out.println(hs.get(1));
    }

}
