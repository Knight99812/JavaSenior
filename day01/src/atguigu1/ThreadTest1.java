package atguigu1;

/**
 * 多线程的创建，方式二：实现Runnable接口
 *
 * @author SHJ
 * @create 2022-12-20 21:20
 */

class MThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread mThread = new MThread();
        Thread t1 = new Thread(mThread);
        t1.start();

        Thread t2 = new Thread(mThread);
        t2.start();
    }
}
