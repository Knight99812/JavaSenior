package atguigu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中的方法测试
 *
 * @author SHJ
 * @create 2022-12-29 21:19
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
//        Person p = new Person("Jerry", 20);
//        coll.add(p);
        coll.add(new Person("Jerry", 20));

        // contains(Object obj) 判断当前集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println(contains);
        System.out.println(coll.contains(new String("Tom")));
//        System.out.println(coll.contains(p));
        System.out.println(coll.contains(new Person("Jerry", 20)));

        // containsAll(Collection coll1) 判断coll1的所有元素是否都在当前集合中
        Collection coll1 = Arrays.asList(123, 4567);
        System.out.println(coll.containsAll(coll1));
    }

    @Test
    public void test2() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // remove(Object obj) 从当前集合中移除obj元素
        coll.remove(1234);
        System.out.println(coll);
        coll.remove(new Person("Jerry", 20));
        System.out.println(coll);

        // removeAll(Collection coll1) 从当前集合中移除coll1中所有元素
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println(coll);
    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // retainAll(Collection coll1) 获取当前集合和coll1的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123, 456, 789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        // equals(Object obj) 判断当前集合和形参元素是否都相同
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add(123);
        coll1.add(new Person("Jerry", 20));
        coll1.add(new String("Tom"));
        coll1.add(false);
        System.out.println(coll.equals(coll1));
    }

    @Test
    public void test4() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("Jerry", 20));
        coll.add(new String("Tom"));
        coll.add(false);

        // hashCode() 返回当前对象的哈希值
        System.out.println(coll.hashCode());

        // toArray() 集合 ---> 数组
        Object[] arr = coll.toArray();
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

        // 数组 ---> 集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List<int[]> arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());
//        List arr1 = Arrays.asList(123, 456);

        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());

        // iterator() 返回Iterator接口的实例，用于遍历集合元素
    }
}
