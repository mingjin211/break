package thread.chapter3;

public class No17BasicModel {

    public static void main(String ars[]) throws Exception {
        Message msg = new Message();
        new Thread(new Producer(msg)).start();
        new Thread(new Consumer(msg)).start();
    }

}

class Producer implements Runnable{
    private Message msg;

    public Producer(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 100 ; i++){
            if(i % 2 == 0){
//                this.msg.setTitle("Yu");
                this.msg.set("Yu","big handsome bro");
//                this.msg.setContent("big handsome bro");
            }else{
//                this.msg.setTitle("Xu");
//                this.msg.setContent("small dd ");
                this.msg.set("Xu","small dd ");
            }
        }
    }
}

class Consumer implements Runnable{
    private Message msg;

    public Consumer(Message msg){
        this.msg = msg;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 100 ; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
//            System.out.println(msg.getTitle() + " - " + msg.getContent());
            System.out.println(msg.get());
        }
    }
}

class Message{
    private String title;
    private String content;

    public synchronized String get(){
        return this.title + " - " + this.content;
    }

    public synchronized void set(String title,String content){
        this.title = title;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}


