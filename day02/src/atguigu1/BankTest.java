package atguigu1;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 *
 * @author SHJ
 * @create 2022-12-22 18:06
 */
public class BankTest {

    public static void main(String[] args) {

    }

}

class Bank {

    private Bank() {

    }

    private static Bank instance = null;

    public static Bank getInstance() {
        // 方式一
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }

        // 方式二
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }

}
