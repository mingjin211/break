package test;

import java.text.SimpleDateFormat;

public class LocalTest {

  public static final ThreadLocal<SimpleDateFormat> sdf = new ThreadLocal<SimpleDateFormat>() {
    @Override
    protected SimpleDateFormat initialValue() {
      return new SimpleDateFormat("yyyy-MM-dd");
    }
  };

  public static void main(String[] args){
    for(int i = 1 ; i <  10 ; i++){
      new Thread(new LocalRunnable()).start();
    }
  }



}

