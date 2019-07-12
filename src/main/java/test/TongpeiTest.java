package test;


class Message<T extends Number>{

  private T note;

  public T getNote() {
    return note;
  }

  public void setNote(T note) {
    this.note = note;
  }
}

public class TongpeiTest {

  private static void print(Message<?> message){
    System.out.println(message.getNote());
  }

  public static void main(String[] args) {
    Message<Integer> msg = new Message<>();
    msg.setNote(9);
    print(msg);
  }

}
