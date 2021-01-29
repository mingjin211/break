package geektime.structure.chapter08Stack;

public class ArrayStackYu<T> {

  private Object[] items;
  private int count;
  private int n;

  ArrayStackYu(int ns){
    this.items = new Object[ns];
    this.count = 0;
    this.n = ns;
  }

  public T pop(){
    if(count == 0) return null;
    return (T)items[--count];
  }

  public boolean push(T s){
    if(count == n)return false;
    items[count++] = s;
    return true;
  }

}
