package atguigu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHJ
 * @create 2023-01-02 20:35
 */
public class SubOrder extends Order<Integer> {

    public static <E> List<E> copyFormArrayToList(E[] arr) {
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

}
