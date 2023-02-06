package atguigu;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author SHJ
 * @create 2022-12-27 15:03
 */
public class OtherClassTest {

    @Test
    public void test1() {
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void test2() {
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12345.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);

//        System.out.println(bd.divide(bd2));
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2, 15, BigDecimal.ROUND_HALF_UP));
    }

}
