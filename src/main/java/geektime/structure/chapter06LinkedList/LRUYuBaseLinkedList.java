package geektime.structure.chapter06LinkedList;


import java.util.Scanner;

public class LRUYuBaseLinkedList<T> {

  /**
   * 默认容量
   */
  private final static Integer DEFAULT_CAPACITY = 3;

  /**
   * 头节点 哨兵
   */
  private SNode<T> headNode;


  /**
   * 列表的长度
   */
  private Integer length;


  /**
   * 缓存的容量
   */
  private Integer capacity;

  public LRUYuBaseLinkedList(){
    this.headNode = new SNode<>();
    this.capacity = DEFAULT_CAPACITY;
    this.length = 0;
  }

  public LRUYuBaseLinkedList(Integer capacity){
    this.headNode = new SNode<>();
    this.capacity = capacity;
    this.length = 0;
  }

  /**
   * 删除末尾结点
   */
  private void deleteLast(){
    SNode node = headNode;
    if(node.getNext() != null){
      while(node.getNext().getNext() != null){
        node = node.getNext();
      }
      node.setNext(null);
      length--;
    }
    //没有考虑释放尾结点
  }

  /**
   * 删除下一个结点
   * @param sNode
   */
  private void deleteNext(SNode sNode){
    if(sNode.getNext() != null){
      SNode tmp = sNode.getNext();
      sNode.setNext(tmp.getNext());
      tmp = null;
      length--;
    }
  }

  /**
   * 头部插入结点
   * @param sNode
   */
  private void insertBegin(SNode sNode){
    sNode.setNext(headNode.getNext());
    headNode.setNext(sNode);
    length++;
//    SNode next = headNode.getNext();
//    headNode.setNext(new SNode(data, next));
//    length++;
  }

  /**
   * 查找其前一结点
   * @param sNode
   * @return
   */
  private SNode findPre(SNode sNode){
    SNode node = headNode;
    SNode result = null;
    while(node.getNext()!=null){
      if(node.getNext().getElement().equals(sNode.getElement())){
        result = node;
        break;
      }
      node = node.getNext();
    }
    return result;
  }

  /**
   * 打印全部
   */
  public void printAll(){
    SNode node = headNode;
    while(node.getNext() != null){
      System.out.print(node.getNext().getElement() + ",");
      node = node.getNext();
    }
    System.out.println();
  }

  public void add(T data){
    SNode sNode = new SNode(data);

    if(headNode.getNext() == null){
      insertBegin(sNode);
      return;
    }

    SNode preNode = findPre(sNode);
    if(preNode != null){
      deleteNext(preNode);
      insertBegin(sNode);
    }else{
      if(length >= capacity){
        deleteLast();
      }
      insertBegin(sNode);
    }
  }

  public static void main(String[] args) {
    LRUYuBaseLinkedList list = new LRUYuBaseLinkedList();
    Scanner sc = new Scanner(System.in);
    while (true) {
      list.add(sc.nextInt());
      list.printAll();
    }
  }

}
