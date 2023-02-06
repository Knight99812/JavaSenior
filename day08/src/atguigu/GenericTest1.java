package atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SHJ
 * @create 2023-01-02 20:28
 */
public class GenericTest1 {

    @Test
    public void test1() {
//        Order order = new Order();
//        order.setOrderT(123);
//        order.setOrderT("ABC");

        Order<String> order1 = new Order<>("orderAA", 1001, "order:AA");
        order1.setOrderT("AA:hello");
    }

    @Test
    public void test2() {
        SubOrder sub1 = new SubOrder();
        sub1.setOrderT(1122);

        SubOrder1<String> sub2 = new SubOrder1<>();
        sub2.setOrderT("order2...");
    }

    @Test
    public void test3() {
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;

//        list1 = list2;
    }

    @Test
    public void test4() {
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        List<Integer> list = order.copyFormArrayToList(arr);

        System.out.println(list);
    }

}
