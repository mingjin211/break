package object;

public class OuterClass {

  //成员内部类
  private class InstancelnnerClass {}
  //静态内部类
  static class StaticinnerClass {}
  public static void main (String []args) {
    //匿名内部类
    (new Thread() {}).start();
    (new Thread() {}).start();
    //方法内部类
    class MethodClassl {}
    class MethodClass2 {}

    Circle c = new Circle(2);
    Circle.Draw draw = c.new Draw();
  }
}