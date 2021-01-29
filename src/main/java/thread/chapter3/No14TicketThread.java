package thread.chapter3;

class TicketThread14 implements Runnable{

  private int ticket = 10;
  @Override
  public void run() {
    while(true){
      if(this.ticket > 0){
        try {
          Thread.sleep(100); //模拟网络延迟
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + "卖票，ticket = " + this.ticket-- );
      }else{
        System.out.println("票已经卖完了");
        break;
      }

    }
  }
}

public class No14TicketThread {

  public static void main(String ars[]){
    TicketThread14 tt = new TicketThread14();
    new Thread(tt,"卖票者A").start();
    new Thread(tt,"卖票者B").start();
    new Thread(tt,"卖票者C").start();
  }
}
