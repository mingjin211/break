package thread.chapter1;

/**
 *
 * 线程第一种实现：继承Thread类，重写该类的run()方法。
 *
 **/
class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {
        for (; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}