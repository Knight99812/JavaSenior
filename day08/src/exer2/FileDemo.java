package exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author SHJ
 * @create 2023-01-04 10:05
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("E:\\code\\Java\\AtGuiGu\\IO流\\io\\io1\\hello.txt");
        File destFile = new File(file.getParent(), "haha.txt");
        boolean newFile = destFile.createNewFile();
        if (newFile) {
            System.out.println("创建成功");
        }
    }

}
