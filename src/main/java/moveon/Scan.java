package moveon;

import java.util.Scanner;

public class Scan {

    public static void main(String args[])
    {
        Scanner cin = new Scanner(System.in);
        int N, M;
        // 读取输入，直到没有整型数据可读
        while(cin.hasNextInt())
        {
            // 读取N 和 M
            N = cin.nextInt();
            M = cin.nextInt();
            System.out.println(String.format("%d %d", N, M));
            // 读取接下来M行
            for (int i=0; i<M; i++) {
                // 读取每行的a b c
                int a = cin.nextInt(),
                        b = cin.nextInt(),
                        c = cin.nextInt();
                System.out.println(String.format("%d %d %d", a, b, c));
            }
        }
    }
}
