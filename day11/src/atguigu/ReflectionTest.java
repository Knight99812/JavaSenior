package atguigu;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author SHJ
 * @create 2023-01-08 10:23
 */
public class ReflectionTest {

    // 反射之前对于Person的操作
    @Test
    public void test1() {
        Person p1 = new Person("Tom", 12);
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
    }

    // 反射之后对于Person的操作
    @Test
    public void test2() throws Exception {
        Class clazz = Person.class;
        // 1、通过反射创建Person类对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p);
        // 2、通过反射调用对象的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(p, 10);
        System.out.println(p);

        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("****************");

        // 通过反射调用Person类的私有结构
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1, "Harry");
        System.out.println(p1);

        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1, "中国");
        System.out.println(nation);
    }

    /*
    关于 java.lang.Class类的理解
    1、类的加载过程：
    程序经过javac.exe命令以后，会生成一个或多个字节码文件（.class结尾），
    接着使用java.exe命令对某个字节码文件进行解释运行，相当于将某个字节码文件加载到内存中。
    加载到内存中的类，就称为运行时类，此运行时类，就作为Class的一个实例

    2、加载到内存中的运行时类，会存放在缓存区一定时间，在此时间内可以通过不同方式
    获取次运行时类
     */

    // 获取Class实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        // 方式二：通过运行时类的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);
        // 方式三：调用Class的静态方法：forName(String classPath)
        Class clazz3 = Class.forName("atguigu.Person");
        System.out.println(clazz3);

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        // 方式四：使用类的加载器 ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("atguigu.Person");
        System.out.println(clazz4);
        System.out.println(clazz1 == clazz4);
    }

    // Class实例可以是哪些结构的说明
    @Test
    public void test4() {
        Class c1 = Object.class;
        Class c2 = Comparable.class;
        Class c3 = String[].class;
        Class c4 = int[][].class;
        Class c5 = ElementType.class;
        Class c6 = Override.class;
        Class c7 = int.class;
        Class c8 = void.class;
        Class c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];
        Class c10 = a.getClass();
        Class c11 = b.getClass();
        // 只要数组元素类型和维度一样，就是同一个Class
        System.out.println(c10 == c11);
    }

}
