package geektime.structure.chapter09Queue;

public class ArrayCyclicQueueYu<T> {

  private Object[] items;
  private int length;
  private int head;
  private int tail;

  ArrayCyclicQueueYu(int n){
    this.items = new Object[n];
    this.length = n;
    this.head = 0;
    this.tail = 0;
  }

  public boolean enqueue(T data){
    if((tail+1) % length == head){
      return false;
    }
    items[tail] = data;
    tail = (tail + 1) % length;
    return true;
  }

  public T dequeue(){
    if(tail == head)return null;
    T tmp = (T)items[head];
    head = (head + 1) % length;
    return tmp;
  }
}
