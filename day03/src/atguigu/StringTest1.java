package atguigu;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * String类与其它结构之间的转换
 *
 * @author SHJ
 * @create 2022-12-24 22:22
 */
public class StringTest1 {

    /*
    String ---> byte[] : 调用String的getBytes()
    byte[] ---> String : 调用String的构造器
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes(); // 使用默认字符集转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk"); // 使用gbk字符集编码
        System.out.println(Arrays.toString(gbks));

        System.out.println("**************************");

        String str2 = new String(bytes);
        System.out.println(str2);

        String str3 = new String(gbks, "gbk");
        System.out.println(str3);
    }

    /*
    String ---> char[] : 调用String的toCharArray()
    char[] ---> String : 调用String的构造器
     */
    @Test
    public void test2() {
        String str1 = "abc123";

        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    @Test
    public void test1() {
        String str1 = "123";
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);
        String str3 = num + "";

        System.out.println(str1 == str3);
    }

}
