package atguigu;

import org.junit.Test;

import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @author SHJ
 * @create 2023-01-08 13:50
 */
public class ClassLoaderTest {

    @Test
    public void test1() {
        // 对于自定义类，使用系统类加载器
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);
        // 扩展类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);
        // 引导类加载器
        // 主要负责加载核心类库，无法加载自定义类
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);

        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /*
    Properties： 用来读取配置文件
     */
    @Test
    public void test2() throws Exception {
        Properties pros = new Properties();
        // 此时文件默认在当前module下
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        pros.load(fis);
        // 此时文件默认在当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);


        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        System.out.println("user = " + user + ",password = " + password);
    }

}
