package exer1;

/**
 * 练习：创建两个分线程，其中一个线程遍历100以内的偶数
 *      另一个线程遍历100以内的奇数
 * @author SHJ
 * @create 2022-12-20 19:56
 */
public class ThreadDemo {
    public static void main(String[] args) {
//        MyTread1 m1 = new MyTread1();
//        MyTread2 m2 = new MyTread2();
//
//        m1.start();
//        m2.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if (i % 2 != 0){
                        System.out.println(Thread.currentThread().getName() + ": " + i);
                    }
                }
            }
        }.start();
    }
}

class MyTread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class MyTread2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0){
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}
