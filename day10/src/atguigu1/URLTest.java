package atguigu1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL的网络编程
 * 1、统一资源定位符，对应互联网的某一资源地址
 * 2、格式
 *    http://locolhost:8080/examples/beauty.jpg？username=Tom
 *    协议    主机名   端口号  资源地址             参数列表
 *
 * @author SHJ
 * @create 2023-01-07 22:15
 */
public class URLTest {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://locolhost:8080/examples/beauty.jpg?username=Tom");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
