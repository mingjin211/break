package collections;


import reflect.ReflectPractice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public boolean isAnagram(String s, String t) {

        char[] one = s.toCharArray();
        char[] two = s.toCharArray();


        return false;
    }

    public static boolean isPalindrome(String s) {

        if (s.length() == 0) return true;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if (!((chars[i] >= 'a' && chars[i] <= 'z') || (chars[i] >= '0' && chars[i] <= '9'))) {
                i++;
                continue;
            }
            if (!((chars[j] >= 'a' && chars[j] <= 'z') || (chars[j] >= '0' && chars[j] <= '9'))) {
                j--;
                continue;
            }
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        Queue<String> queue = new LinkedList();
//
////        queue.offer("1");
////        queue.offer("2");
////        queue.offer("3");
////
////        System.out.println(queue.poll());
////
////        System.out.println(queue.poll());
////        System.out.println(queue.poll());

        HashMap<String,List<String>> map = new HashMap<String,List<String>>();
        map.put("a",new ArrayList<String>());
        map.put("c",new ArrayList<String>());

        map.keySet().contains("");



//        String co = "";
//        ReflectPractice.verifyArg(co);
        Queue queue = new Queue();
        isPalindrome("A man, a plan, a canal: Panama");

        String time = "2018-09-29T22:21:29.420571";
//        time = time.replace("Z", " UTC");
        //UTC是本地时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSS",Locale.ENGLISH);
        Date d = null;
        try {
            d = format.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        //calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳

        int x = 1;
        int y;
        char c;

        System.out.println("北京时间: " + calendar.getTime());

        Date de = calendar.getTime();




//        // 此处是将date类型装换为字符串类型，比如：Sat Nov 18 15:12:06 CST 2017转换为2017-11-18 15:12:06
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = sf.format(d);System.out.println(d);//这里输出的是date类型的时间
//        System.out.println(d.getTime()/1000);//这里输出的是以秒为单位的long类型的时间。如果需要一毫秒为单位，可以不用除1000.
//        System.out.println(sf.format(d));//这里输出的是字符串类型的时间}

    }
}
