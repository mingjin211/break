package geektime.structure.chapter09Queue;

public class ArrayQueueYu<T> {

  private Object[] items;
  private int length;
  private int head;
  private int tail;


  ArrayQueueYu(int n){
    this.items = new Object[n];
    this.length = n;
    this.head = 0;
    this.tail = 0;
  }

  public boolean enqueue(T data){
    if(tail == length){
      if(head == 0)return false;
      for(int i = head ; i < tail ; i++) {
        items[i - head] = items[i];
      }
      //搬完之后忘记更新tail和head了
      tail = tail - head;
      head = 0;
      //************************
    }
    items[tail++] = data;
    return true;
  }

  public T dequeue(){
    if(tail == head)return null;
    return (T)items[head++];
  }

}
