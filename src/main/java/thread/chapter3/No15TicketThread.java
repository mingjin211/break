package thread.chapter3;

//class TicketThread15 implements Runnable{
//
//  private int ticket = 100;
//  @Override
//  public void run() {
//    while(true){
//      synchronized (this){
//        if(this.ticket > 0){
//          try {
//            Thread.sleep(100); //模拟网络延迟
//          } catch (InterruptedException e) {
//          }
//          System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket-- );
//        }else{
//          System.out.println("票已经卖完了");
//          break;
//        }
//      }
//    }
//  }
//}

class TicketThread15 implements Runnable{

  private int ticket = 100;
  private synchronized boolean sale(){
    if(this.ticket > 0){
      try {
        Thread.sleep(100); //模拟网络延迟
      } catch (InterruptedException e) {
      }
      System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket-- );
      return true;
    }else{
      System.out.println("票已经卖完了");
      return false;
    }
  }
  @Override
  public void run() {
    while(this.sale()){
    }
  }
}



public class No15TicketThread {

  public static void main(String ars[]){
    TicketThread15 tt = new TicketThread15();
    new Thread(tt,"卖票者A").start();
    new Thread(tt,"卖票者B").start();
    new Thread(tt,"卖票者C").start();
  }
}
