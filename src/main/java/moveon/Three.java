package moveon;

import java.util.Scanner;

/**
 * 两人同行，一人免单
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 问春节前夕，某超市推出“两人同行，一人免单”活动。小胡和小谢一起去购物，他们采购的物品价格各不相同。超市规定，他们可以交换一件
 * 所购物品使两人购物的金额相等，这样就可以按半价结算。 请使用你熟悉的语言编写程序，帮助他们找出需交换物品的金额。
 * 若交换物品后仍不能使两人的购物金额相等，则返回空值。
 * 输入描述
 * 输入为两个数组，分别为小胡、小谢所购物品的金额。
 * 输出描述
 * 输出两个数组中，从第一个数组出发第一个匹配的可以相互交换的值
 * 样例输入
 * 5
 * 3
 * 3
 * 4
 * 5
 * 6
 *
 * 5
 * 6
 * 5
 * 4
 * 3
 * 1
 * 样例输出
 * 4
 * 3
 *
 * 提示
 * 输入时每个数组输入前需要先输入数组长度，输入样例中，第一个5代表下面输入的数组长度为5，以此类推
 */
public class Three {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int hu = in.nextInt();
        int[] hus = new int[hu];
        int hutotal = 0;
        for(int i = 0 ; i < hus.length ; i++){
            hus[i] = in.nextInt();
            hutotal += hus[i];
        }
        int xie = in.nextInt();
        int[] xies = new int[xie];
        int xietotal = 0;
        for(int i = 0 ; i < xies.length ; i++){
            xies[i] = in.nextInt();
            xietotal += xies[i];
        }
        int h = 0;
        int x = 0;
        for(int i = 0 ; i < hus.length ; i++){
            h = hus[i];
            for(int j = 0 ; j < xies.length ; j++){
                x = xies[j];
                if((hutotal - h + x) == (xietotal + h - x)){
                    System.out.println(h);
                    System.out.println(x);
                    return;
                }
            }
        }

//        System.out.println("%d %d",h,x);

    }


}
