package atguigu;

import org.junit.Test;

import java.util.Random;

/**
 * 通关反射创建对应的运行时类的对象
 *
 * @author SHJ
 * @create 2023-01-09 8:15
 */
public class NewInstanceTest {

    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        /*
         newInstance(): 创建对应的运行时类的对象。内部调用了对应的空参构造器
                        此方法要求必须提供空参构造器，且其访问权限不为private
         */
        Person obj = clazz.newInstance();
        System.out.println(obj);
    }

    // 反射的动态性
    @Test
    public void test2() {
        int num = new Random().nextInt(3);// 0,1,2
        String classPath = "";
        switch(num) {
            case 0:
                classPath = "java.util.Date";
                break;
            case 1:
                classPath = "java.lang.Object";
                break;
            case 2:
                classPath = "atguigu.Person";
                break;
        }

        try {
            Object obj = getInstance(classPath);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个指定类的对象
     *
     * @param classPath  指定类的全类名
     * @return           创建的对象
     * @throws Exception 异常
     */
    public Object getInstance(String classPath) throws Exception {
        Class<?> clazz = Class.forName(classPath);
        return clazz.newInstance();
    }

}
