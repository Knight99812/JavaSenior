package atguigu;

import org.junit.Test;

import java.util.*;

/**
 * @author SHJ
 * @create 2023-01-02 17:59
 */
public class GenericTest {

    // 不使用泛型
    @Test
    public void test1() {
        ArrayList list = new ArrayList();
        // 存放学生成绩
        list.add(78);
        list.add(76);
        list.add(89);
        list.add(88);
//        list.add("Tom"); // 问题1：类型不安全

        for (Object score : list) {
            // 问题2：强转时出现类型转换异常
            int stuScore = (Integer) score;
            System.out.println(stuScore);
        }
    }

    // 使用泛型
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(78);
        list.add(87);
        list.add(99);
        list.add(65); // 编译时会进行类型检查

//        for (Integer score : list) {
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int stuScore = iterator.next();
            System.out.println(stuScore);
        }
    }

    @Test
    public void test3() {
        Map<String,Integer> map = new HashMap<String,Integer>();

        map.put("Tom", 87);
        map.put("Jerry", 87);
        map.put("Jack", 67);

        // 泛型的嵌套
        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> e = iterator.next();
            String key = e.getKey();
            Integer value = e.getValue();
            System.out.println(key + "---->" + value);
        }
    }

}
