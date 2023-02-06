package atguigu;

import org.junit.Test;

/**
 * String类的常用方法
 *
 * @author SHJ
 * @create 2022-12-24 21:16
 */
public class StringMethodTest {

    @Test
    public void test4() {
        String str1 = "北京尚硅谷教育北京";
        String str2 = str1.replace("北", "东");

        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);
    }

    @Test
    public void test3() {
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("r1d");
        System.out.println(b1);

        boolean b2 = str1.startsWith("He");
        System.out.println(b2);

        boolean b3 = str1.startsWith("ll", 2);
        System.out.println(b3);

        String str2 = "wo";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf(str2));

        System.out.println(str1.indexOf(str2, 6));

        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or", 6));
    }
    
    @Test
    public void test2() {
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abcd");
        System.out.println(s5.compareTo(s6)); // 涉及到字符串排序

        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);

        String s9 = s7.substring(2, 5);
        System.out.println(s9);
    }

    @Test
    public void test1() {
        String s1 = "HelloWorld";

        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.toUpperCase());

        String s3 = "   he   llo world    ";
        String s4 = s3.trim();  // 去除前后多余的空格
        System.out.println("-----" + s3 + "-----");
        System.out.println("-----" + s4 + "-----");

    }

}
