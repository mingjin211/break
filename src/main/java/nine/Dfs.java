package nine;

public class Dfs {

    int goal_x,goal_y;     //目标的坐标，暂时设置为右下角
    int n,m;               //地图的宽高，设置为10 * 10的表格
    static int[][] graph;        //地图
    static int[][] used;         //用来标记地图上那些点是走过的
    int[] px = {-1, 0, 1, 0};   //通过px 和 py数组来实现左下右上的移动顺序
    int[] py = {0, -1, 0, 1};
    boolean flag;           //是否能达到终点的标志

    {
        goal_x = 9;
        goal_y = 9;
        n = 10;
        m = 10;
        graph = new int[n][m];
        used = new int[n][m];
        flag = false;
    }

    public static void main(String[] args) {
//        Dfs dfs = new Dfs();
//        dfs.DFS(graph,used,2,3);
        String[] a = new String[2];
        Object[] b = a;
        a[0] = "hi";
        b[1] = Integer.valueOf(42);
    }

    public void DFS(int[][] graph, int[][] used, int x, int y)
    {
        // 如果与目标坐标相同，则成功
        if (x==goal_x && y==goal_y) {
            System.out.println("successful");
            flag = true;
            return ;
        }
        // 遍历四个方向
        for (int i = 0; i != 4; ++i) {
            //如果没有走过这个格子
            int new_x = x + px[i], new_y = y + py[i];
            if (new_x >= 0 && new_x < n && new_y >= 0
                    && new_y < m && used[new_x][new_y] == 0 && !flag) {
                System.out.println(String.format("走到:x:%d,y:%d",new_x,new_y));
                used[new_x][new_y] = 1;     //将该格子设为走过

                DFS(graph, used, new_x, new_y);      //递归下去
                System.out.println(String.format("回到:x:%d,y:%d",new_x,new_y));
                used[new_x][new_y] = 0;//状态回溯，退回来，将格子设置为未走过
            }
        }
    }

}
