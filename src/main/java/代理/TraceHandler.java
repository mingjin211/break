package 代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class TraceHandler implements InvocationHandler {

    private Object target;

    public TraceHandler(Object o){
        target = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target);
        System.out.print("." + method.getName() + "(");
        if(args != null){
            for(int i = 0 ; i < args.length ; i ++){
                System.out.print(args[i]);
                if(i < args.length -1 ){
                    System.out.print(",");
                }
            }
        }
        System.out.println(")");
        return method.invoke(target,args);
    }

    public static void main(String[] args){
        Object[] elements = new Object[1000];
        for(int i = 0 ; i <1000 ; i++){
            Integer value = i + 1;
            elements[i] = Proxy.newProxyInstance(null,new Class[]{Comparable.class},new TraceHandler(value));
        }
        Integer key = new Random().nextInt(elements.length) + 1;

        int result = Arrays.binarySearch(elements,key);

        if(result > 0){
            System.out.println(elements[result]);
        }

    }
}
