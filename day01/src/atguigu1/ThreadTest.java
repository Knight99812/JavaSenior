package atguigu1;

/**
 * 多线程的创建，方式一：继承于Thread类
 * 遍历100以内的所有偶数
 *
 * @author SHJ
 * @create 2022-12-20 19:14
 */

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
//        t1.run();

        MyThread t2 = new MyThread();
        t2.start();

        for (int i = 0; i < 100; i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i + "*****main*****");
            }
        }
    }
}
