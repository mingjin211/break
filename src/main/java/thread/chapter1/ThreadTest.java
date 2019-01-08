package thread.chapter1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    public static void main(String[] args) {
//        for (int i = 0; i < 20; i++) {
//            System.out.println(Thread.currentThread().getName() + " " + i);
//            if (i == 5) {
//                Thread myThread1 = new MyThread();     // 创建一个新的线程  myThread1  此线程进入新建状态
//                Thread myThread2 = new MyThread();     // 创建一个新的线程 myThread2 此线程进入新建状态
//                myThread1.start();                     // 调用start()方法使得线程进入就绪状态
//                myThread2.start();                     // 调用start()方法使得线程进入就绪状态
//            }
//        }
        Callable<Integer> myCallable = new MyCallable();    // 创建MyCallable对象
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable); //使用FutureTask来包装MyCallable对象

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 30) {
                Thread thread = new Thread(ft);   //FutureTask对象作为Thread对象的target创建新的线程
                thread.start();                      //线程进入到就绪状态
            }
        }

        System.out.println("主线程for循环执行完毕..");

        try {
            int sum = ft.get();            //取得新创建的新线程中的call()方法返回的结果
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
