package atguigu;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author SHJ
 * @create 2022-12-26 14:06
 */
public class DateTimeTest {

    @Test
    public void test2() {
        Date date1 = new Date();
        System.out.println(date1.toString());
        System.out.println(date1.getTime());

        Date date2 = new Date(1550306204104L);
        System.out.println(date2);

        java.sql.Date date3 = new java.sql.Date(1550306204104L);
        System.out.println(date3);

        // 将util.Date对象转为sql.Date对象
        Date date4 = new java.sql.Date(2343243242323L);
        java.sql.Date date5 = (java.sql.Date) date4;

        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());
    }

    @Test
    public void test1() {
        long time = System.currentTimeMillis();
        // 返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        // 称为时间戳
        System.out.println(time);
    }

}
