package mobile;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/9b59014cc1544aeeb4082f5f37ecfaea?answerType=1&f=discussion
 * 来源：牛客网
 *
 * 牛牛和妞妞去海边捡了一大袋美丽的贝壳，千辛万苦地运回家后，牛牛和妞妞打算分掉这些贝壳。
 * 牛牛提出，他和妞妞轮流从还没有分配的贝壳中取一定数量的贝壳，直到贝壳分完为止。分配规则是牛牛每次取剩余贝壳的1/10（向下取整），妞妞每次固定取m个贝壳，妞妞先取。
 * 妞妞想要得到不少于一半的贝壳，又不想太过分，那么她一次最少取多少个贝壳才能得到不少于一半的贝壳呢？
 *
 * 输入描述:
 * 一个正整数n，表示贝壳的总数量，1<=n<=1000000000000000000。
 *
 *
 * 输出描述:
 * 一个正整数m，表示妞妞一次最少取的贝壳数量。
 * 示例1
 * 输入
 * 10
 * 输出
 * 1
 * 示例2
 * 输入
 * 70
 * 输出
 * 3
 */
public class Main {


    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        long l = 1;
        long r = n/10 +1; //范围肯定是在1-n/10之中 因为拿了n/10以上 妞妞就太过分了
        long result = 0; //妞妞每次要拿的量
        while(l <= r){
            long mid = l + (r- l)/2; //二分法取区间的中间值
            long temp = n; // 表示剩余贝壳数量
            long sum = 0; // 表示妞妞取到的总量
            while(temp >= mid){ //表示取完 因为temp<mid 妞妞就全取完了
                sum += mid; //妞妞取mid个
                temp -= mid; //总数减少temp个
                temp = temp - (temp)/10; // 牛牛取剩下的十分之一后的数量
            }
            if(sum + temp >= (n+1)/2){ //sum+temp表示妞妞最后取到的总数 //如果大于一半 则是一个符合的数
                result = mid;
                r = mid - 1; //缩小右边界
            }else { //说明mid不够大 缩小左边界
                l = mid + 1;
            }
        }
        System.out.println(result);
    }
//    public static void main(String args[]){
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//
//        Date start = calendar.getTime();
//
//        calendar.add(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
//        calendar.add(Calendar.SECOND, -1);
//
//        Date end = calendar.getTime();
//
//        System.out.println(start);
//        System.out.println(end);
//        //获取上个月结束时间
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar c = Calendar.getInstance();
//        c.add(Calendar.MONTH, -1);
//        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));//设置为1号,当前日期既为本月第一天
//        c.set(Calendar.HOUR_OF_DAY,23);
//        c.set(Calendar.MINUTE,59);
//        c.set(Calendar.SECOND,59);
//        String monthfirst = sdf.format(c.getTime());
//        System.out.println("===============nowfirst:" + monthfirst);
//
//        //获取下个月开始时间
//        Calendar ca = Calendar.getInstance();
//        ca.add(Calendar.MONTH, 1);
//        ca.set(Calendar.DAY_OF_MONTH, 1);
//        ca.set(Calendar.HOUR_OF_DAY,0);
//        ca.set(Calendar.MINUTE,0);
//        ca.set(Calendar.SECOND,0);
//        String monthlast = sdf.format(ca.getTime());
//        System.out.println("===============last:" + monthlast);

//    }
}
