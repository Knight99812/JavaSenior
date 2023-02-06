package atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * List接口中的常用方法
 *
 * @author SHJ
 * @create 2022-12-30 10:53
 */
public class ListTest {

    @Test
    public void test3() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");

        // 方式一：迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("**************");

        // 方式二：增强for循环
        for (Object obj : list)
            System.out.println(obj);

        System.out.println("**************");

        // 方式三：普通for循环
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }

    @Test
    public void test2() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        // int indexOf(Object obj)   不存在返回-1
        int index = list.indexOf(456);
        System.out.println(index);

        // int lastIndexOf(Object obj)
        System.out.println(list.lastIndexOf(456));

        // Object remove(int index)
        Object obj = list.remove(0);
        System.out.println(obj);
        System.out.println(list);

        // Object set(int index, Object ele)
        list.set(1, "CC");
        System.out.println(list);

        // List subList(int fromIndex, int toIndex)
        List subList = list.subList(2, 4);
        System.out.println(subList);
    }

    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);

        System.out.println(list);

        // boolean add(int index, Object ele)
        list.add(1, "BB");
        System.out.println(list);

        // boolean addAll(int index, Collection eles)
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        list.addAll(list1);
        System.out.println(list.size());

        // Object get(int index)
        System.out.println(list.get(0));
    }

}
