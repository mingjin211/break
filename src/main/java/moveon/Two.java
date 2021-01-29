package moveon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 疯狂购物
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 众所周知，约翰在数学方面并不那么好。不过，他一直在努力使自己尽可能便宜。令人惊讶的是，约翰并不总是那样。当他访问克罗地亚的克尔克岛时，
 * 他学会了如何省钱并尽可能提高效率。好，时间到了。约翰必须向自己证明自己在购物时会非常有效率。约翰家附近有一家超市，在那里他看到了一笔大买卖的招牌。
 *
 * 在那家超市里有N个物品。每个项目都有自己的价格P i。约翰想得到M件物品，但他只想要便宜的物品。因此，您的任务是获取M个最便宜的商品并打印出其价格的总和。
 *
 *
 *
 * 约束
 *
 * 1 ≤ N ≤ 107 0 ≤ Pi ≤ 103 0 ≤ M ≤ N
 *
 *
 *
 * 输入
 * 第一行包含一个整数N，即市场上可用的项目数。然后在下一行中，有N个以空格分隔的整数，它们表示价格P i。然后，第三行包含另一个整数M，即约翰决定购买的商品数量。
 *
 *
 *
 * 输出
 * 打印最便宜的John可以购买的M的总成本。
 *
 *
 * 样例输入
 * 5
 * 5 4 3 2 1
 * 2
 * 样例输出
 * 3
 */
public class Two {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] p = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            p[i] = in.nextInt();
        }
        int m = in.nextInt();
        Arrays.sort(p);
        int result = 0;
        for(int i = 0 ; i < m ; i++){
            result += p[i];
        }
        System.out.println(result);
    }
}
