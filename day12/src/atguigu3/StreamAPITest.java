package atguigu3;

import atguigu2.Employee;
import atguigu2.EmployeeData;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamAPI的测试
 *
 * @author SHJ
 * @create 2023-01-12 9:08
 */
public class StreamAPITest {

    // 创建Stream方式一：通过集合
    @Test
    public void test1() {
        List<Employee> employees = EmployeeData.getEmployees();
        // 返回一个顺序流
        Stream<Employee> stream = employees.stream();
        // 返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();
    }

    // 创建Stream方式二：通过数组
    @Test
    public void test2() {
        int[] arr = new int[]{1,2,3,4,5,6};
        IntStream stream = Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"Jerry");
        Employee[] arr1 = new Employee[]{e1,e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
    }

    // 创建Stream方式三：通过Stream的of()
    @Test
    public void test3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
    }

    // 创建Stream方式四：创建无限流
    @Test
    public void test4() {
        // 遍历前10个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

}
