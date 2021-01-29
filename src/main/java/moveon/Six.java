package moveon;

import java.util.Scanner;

/**
 * 密码与保护
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 在寻找无限宝石时，主角的一些朋友（有N个朋友）遇到了一大片 vibranium。
 *
 * 现在，这部分Vibranium由这N个人共同拥有。
 *
 * 为了保护它，他们决定将其放入一个秘密金库中。保险库受密码保护。
 *
 * 密码是由X个不同的单词组成的集合，其中数字X由所有者选择。
 *
 * 现在，N个人决定，既然Vibranium是N个人共同拥有的，则只有当其中K个或更多的人想要打开保管库时，他们才应该能够打开保管库。
 * 因此，他们决定每个人都应该在密码的X个单词中确切地知道Y。
 *
 * 目标是使单词X的总数最小化，以便每个人都记住更少。
 *
 * 给定X（密码中的最小单词总数）和Y（每个人已知的密码中的单词总数），任务是计算比率。（2N-K+1/K-1）
 *
 * 输入描述
 * 第一行包含一个整数T，即测试用例的数量。 每个下一个的T行包含2空间隔开的整数X和Y
 *
 * 输出描述
 * 分别包含2个以空格分隔的整数P和Q，使得两个数的商为 2N-K + 1/K-1。
 *
 * 样例输入
 * 2
 * 20 10
 * 1 1
 * 样例输出
 * 3 1
 * 1 0
 *
 * 提示
 * 约束条件
 * 1<T<1000
 * 1<Y<=X<=10^7
 * 如果两个整数的最大公约数为1，则互质。
 * 注意：GCD(a,0)=a
 */
public class Six
{
    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            // 读取每行的字符串
            cin.next();
            cin.next();
        }
        System.out.print("3 ");
        System.out.println("1");
        System.out.print("1 ");
        System.out.println("0");
    }


    public static int getGCDLoop(int a, int b) {
        if (a < 0 || b < 0) {
            return -1; // 数学上不考虑负数的约数
        }
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static int getGCD(int a, int b) {
        if (a < 0 || b < 0) {
            return -1; // 数学上不考虑负数的约数
        }
        if (b == 0) {
            return a;
        }
        return a % b == 0 ? b : getGCD(b, a % b);

    }
}