package thread.chapter3;

public class No16LockThread {

    public static void main(String ars[]){
        new ThreadLock16();
    }
}

class ThreadLock16 implements Runnable{
    private Yu yu = new Yu();
    private Xu xu = new Xu();

    @Override
    public void run() {
        yu.say(xu);
    }

    ThreadLock16(){
        new Thread(this).start();
        xu.say(yu);
    }
}

class Yu{
    public synchronized void say(Xu xu){
        System.out.println("Yu:徐哥必须给我10块钱");
        xu.get();
    }
    public synchronized void get(){
        System.out.println("Yu:拿到了10块钱");
    }
}

class Xu{
    public synchronized void say(Yu yu){
        System.out.println("Xu:先让我过去，再给钱");
        yu.get();
    }
    public void get(){
        System.out.println("Xu:逃过一劫");
    }
}
