package atguigu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author SHJ
 * @create 2023-01-02 10:03
 */
public class PropertiesTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();

            fis = new FileInputStream("jdbc.properties");

            pros.load(fis);

            String name = pros.getProperty("name");
            String password = pros.getProperty("password1");

            System.out.println("name = " + name + ", password = " + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null)
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
