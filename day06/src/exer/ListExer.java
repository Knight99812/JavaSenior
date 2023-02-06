package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHJ
 * @create 2022-12-31 14:18
 */
public class ListExer {

    @Test
    public void testListRemove() {
        List list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private static void updateList(List list) {
//        list.remove(2);
        list.remove(new Integer(2));
        System.out.println(list.getClass());
    }

}
