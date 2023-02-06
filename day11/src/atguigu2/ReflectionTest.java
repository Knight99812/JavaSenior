package atguigu2;

import atguigu1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构：属性、方法、构造器
 *
 * @author SHJ
 * @create 2023-01-09 11:27
 */
public class ReflectionTest {

    @Test
    public void testField() throws Exception {
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person p = clazz.newInstance();

        // 获取指定的权限为public的属性
        Field id = clazz.getField("id");

        // 设置当前属性的值
        id.set(p, 1001);

        // 获取当前属性的值
        int pId = (int) id.get(p);
        System.out.println(pId);
    }

    @Test
    public void testField1() throws Exception {
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person p = clazz.newInstance();

        // 获取指定名的属性
        Field name = clazz.getDeclaredField("name");

        // 保证当前属性是可访问的
        name.setAccessible(true);
        name.set(p, "Tom");
        System.out.println(name.get(p));
    }

    @Test
    public void testMethod() throws Exception {
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person p = clazz.newInstance();

        // 获取指定的某个方法
        Method show = clazz.getDeclaredMethod("show", String.class);
        show.setAccessible(true);
        Object returnValue = show.invoke(p, "CHN");
        System.out.println(returnValue);

        System.out.println("*******************");

        // 调用静态方法
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        // 如果调用的方法没有返回值，则invoke()方法返回null
        Object returnVal = showDesc.invoke(Person.class);
        System.out.println(returnVal);

    }

    @Test
    public void testConstructor() throws Exception {
        Class<Person> clazz = Person.class;

        // 创建运行时类的对象
        Person p = clazz.newInstance();

        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);

        // 调用构造器创建运行时类对象
        Person person = constructor.newInstance("Tom");
        System.out.println(person);
    }

}
