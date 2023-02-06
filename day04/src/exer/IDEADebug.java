package exer;

import org.junit.Test;

/**
 * @author SHJ
 * @create 2022-12-26 14:58
 */
public class IDEADebug {

    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());

        System.out.println(sb);

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }

}
