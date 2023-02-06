package atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author SHJ
 * @create 2023-01-02 10:34
 */
public class CollectionsTest {

    @Test
    public void test2() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

//        List dest = new ArrayList();
//        Collections.copy(dest, list);

        List dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.getClass());
        System.out.println(dest.size());
        Collections.copy(dest, list);

        System.out.println(dest);

        // list1为线程安全的集合
        List list1 = Collections.synchronizedList(list);
    }

    @Test
    public void test1() {
        List list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(765);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

//        Collections.reverse(list);
//        Collections.shuffle(list);
//        Collections.sort(list);
//        Collections.swap(list, 1, 2);
        int frequency = Collections.frequency(list, 765);

        System.out.println(list);
        System.out.println(frequency);
    }

}
