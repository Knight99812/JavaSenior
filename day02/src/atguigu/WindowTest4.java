package atguigu;

/**
 * @author SHJ
 * @create 2022-12-21 17:55
 */
class Window4 extends Thread {

    private static int ticket = 100;

    private static synchronized void show() {
        if (ticket > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为: " + ticket);
            ticket--;
        }
    }

    @Override
    public void run() {
        while (true) {
            show();
        }
    }
}

public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
