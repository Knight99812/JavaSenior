package atguigu3;

import atguigu2.Employee;
import atguigu2.EmployeeData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author SHJ
 * @create 2023-01-12 9:32
 */
public class StreamAPITest1 {

    // 1-筛选与切片
    @Test
    public void test1() {
        List<Employee> list = EmployeeData.getEmployees();
        Stream<Employee> stream = list.stream();
        // filter(Predicate p)--- 接收Lambda，从流中排除某些元素
        stream.filter(e -> e.getSalary() > 7000).forEach(System.out::println);

        System.out.println();
        // limit(n)--- 截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();
        // skip(n)--- 跳过元素，返回一个扔掉前n个元素的流，若流中元素不足n个，则返回一个空流
        list.stream().skip(3).forEach(System.out::println);

        System.out.println();
        // distinct()--- 筛选，通过流所生成元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.stream().distinct().forEach(System.out::println);
    }

    // 2-映射
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        // map(Function f)--- 将元素转换成其它形式或提取信息，该函数会被应用到每个元素，并生成新元素
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println();
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> namesStream = employees.stream().map(Employee::getName);
        namesStream.filter(name -> name.length() > 3).forEach(System.out::println);

        System.out.println();
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });
        // flatMap(Function f)--- 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连成一个流
        System.out.println();
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToStream);
        characterStream.forEach(System.out::println);
    }

    public static Stream<Character> fromStringToStream(String str) {
        ArrayList<Character> list = new ArrayList<>();
        for (Character c : str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3() {
        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList();
        list2.add(1);
        list2.add(2);
        list2.add(3);

//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }

    // 3-排序
    @Test
    public void test4() {
        // sorted()--- 自然排序
        List<Integer> list = Arrays.asList(12, 43, 65, 34, 87, 0, -98, 7);
        list.stream().sorted().forEach(System.out::println);

        System.out.println();
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);

        // sorted(Comparator com)--- 定制排序
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2) -> Integer.compare(e1.getAge(),e2.getAge()))
                .forEach(System.out::println);
    }

}
