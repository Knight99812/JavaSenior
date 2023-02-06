package atguigu;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Java比较器
 *
 * @author SHJ
 * @create 2022-12-27 12:58
 */
public class CompareTest {

    // Comparable接口的使用
    @Test
    public void test1() {
        String[] arr = new String[] {"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microsoftMouse", 43);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // Comparator接口的使用
    @Test
    public void test3() {
        String[] arr = new String[] {"AA", "CC", "KK", "MM", "GG", "JJ", "DD"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test4() {
        Goods[] arr = new Goods[5];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 12);
        arr[3] = new Goods("huaweiMouse", 65);
        arr[4] = new Goods("microsoftMouse", 43);

        Arrays.sort(arr, new Comparator<Goods>() {
            @Override
            public int compare(Goods o1, Goods o2) {
                if (o1.getPrice() < o2.getPrice()){
                    return 1;
                } else if (o1.getPrice() > o2.getPrice()){
                    return -1;
                } else {
                    return -o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
