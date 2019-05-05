package practice;

// FieldAccess.java
// Direct field access is determined at compile time.
//域是不具有多态性的，只有普通的方法调用是多态的。如果直接访问某个域，这个访问就将在编译期进行解析，即域是静态解析的。
//如下，当Sub对象转型为Super引用时，任何域访问操作都将由编译器解析，因此不是多态的。
// Super.field和Sub.field分配了不同的存储空间。这样，Sub实际上包含两个称为field的域：它自己的和它从Super处得到的。

class Super{
    public int field = 0;
    public int getField(){return field;}
}
class Sub extends Super{
    public int field = 1;
    public int getField(){return field;}
    public int getSuperField(){return super.getField();}
}
public class FieldAccess{
    public static void main(String[] args){
        Super sup = new Sub();  // Upcast
        System.out.println("sup.field = " + sup.field + ". sup.getField() = " + sup.getField());
        Sub sub = new Sub();
        System.out.println("sub.field = " + sub.field + ". sub.getFiled() = " + sub.getField() + ". sub.getSuperField() = " + sub.getSuperField());
    }
}
/** Output:
 *  sup.field = 0. sup.getField() = 1
 *  sub.field = 1. sub.getFiled() = 1. sub.getSuperField() = 0
 */