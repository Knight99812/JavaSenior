package atguigu;

import org.junit.Test;

import java.io.*;

/**
 * @author SHJ
 * @create 2023-01-04 16:52
 */
public class FileReaderWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            // 1、实例化File类对象，指明要操作的文件
            File file = new File("hello.txt"); // 相较于当前Module
            // 2、提供具体的流
            fr = new FileReader(file);

            // 3、数据的读入
            // read(): 返回读入的一个字符，如果达到文件末尾，返回-1
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4、流的关闭操作
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);

            char[] cbuf = new char[5];
            int len;
            // read(char[] cbuf): 返回每次读入数组中的字符个数
            while ((len = fr.read(cbuf)) != -1) {
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }

                String str = new String(cbuf, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testFileWriter() throws IOException {
        // 1、提供File类对象
        File file = new File("hello1.txt");
        // 2、提供FileWriter类对象用于数据写出
        FileWriter fw = new FileWriter(file);
        // 3、数据的写出
        fw.write("I have a dream!\n");
        fw.write("you need to have a dream!");
        // 4、流的关闭操作
        fw.close();
    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            File srcFile = new File("hello.txt");
            File destFile = new File("hello2.txt");

            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                fw.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
