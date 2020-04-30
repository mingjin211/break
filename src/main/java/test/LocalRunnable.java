package test;

import java.util.Date;

public class LocalRunnable implements Runnable {
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + ":" + LocalTest.sdf.get().format(new Date()));
  }
}
