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
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                this.msg.setTitle("Yu");
                this.msg.setContent("big handsome bro");
            }else{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                this.msg.setTitle("Xu");
                this.msg.setContent("small dd ");
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
            System.out.println(msg.getTitle() + " - " + msg.getContent());
        }
    }
}

class Message{
    private String title;
    private String content;

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


