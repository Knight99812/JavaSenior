package atguigu2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Collection方法的使用
 *
 * @author SHJ
 * @create 2022-12-28 20:19
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();

        // add(Object e) 添加元素
        coll.add("AA");
        coll.add("BB");
        coll.add(123);  // 自动装箱
        coll.add(new Date());

        // size() 获取元素个数
        System.out.println(coll.size());

        // addAll(Collection coll1) 将集合中的元素添加到当前集合中
        Collection coll1 = new ArrayList();
        coll1.add(456);
        coll1.add("CC");
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        // clear() 清空集合元素
        coll.clear();

        // isEmpty() 判断当前集合是否为空
        System.out.println(coll.isEmpty());
    }

}
