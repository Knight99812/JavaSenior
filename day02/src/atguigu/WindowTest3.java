package atguigu;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * @author SHJ
 * @create 2022-12-21 17:48
 */

class Window3 implements Runnable {

    private int ticket = 100;

    private synchronized void show() {
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

public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w = new Window3();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
