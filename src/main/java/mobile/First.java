package mobile;
import java.util.*;

/**
 *
 *
 * ASCII范围
 * a-z：97-122
 *
 * A-Z：65-90
 *
 * 0-9：48-57
 *
 *
 * 成绩排序
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 输入的第一行为n（n<40）,表示有n个同学，接下来的n行每行有4个输入，分别为该学生的名字,语、数、外成绩，请按照排序规则对学生进行排序，规则如下：
 *
 * 1、总成绩高的排在前面
 *
 * 2、总成绩相同的情况下，语文成绩高的排在前面。
 *
 * 3、在总成绩，语文成绩都相同的情况下，数学成绩高的排在前面。
 *
 * 4、在成绩都相同的情况下，先输入的同学排在前面。
 *
 * 输入
 * 每个测试文件的第一行包含一个整数，即同学个数。
 *
 * 接下来的n行中的每行包含一个字符串s [i]，分别是每个同学的名字和分数。
 *
 *
 * 输出
 * 排好序的分数。
 *
 *
 * 样例输入
 * 3
 * aa 70 80 75
 * bb 80 85 90
 * cc 60 65 88
 * 样例输出
 * bb 80 85 90
 * aa 70 80 75
 * cc 60 65 88
 *
 *
 *
 */
public class First {

    public static class Score{
        public String name;
        public int yuwen;
        public int shuxue;
        public int yingyu;
        public int allScores;

        public Score(String name,int x,int y,int z){
            this.name = name;
            this.yuwen=x;
            this.shuxue=y;
            this.yingyu=z;
            this.allScores=x+y+z;
        }
    }

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n;
        List<Score> scores = new ArrayList<>();
        if(in.hasNext())
        {
            n = Integer.parseInt(in.nextLine());
            for (int i=0; i<n; i++) {
                String line = in.nextLine();
                String[] lines = line.split(" ");
                String name =lines[0];
                int x = Integer.parseInt(lines[1]);
                int y = Integer.parseInt(lines[2]);
                int z = Integer.parseInt(lines[3]);
                scores.add(new Score(name,x,y,z));
            }
            Collections.sort(scores,new Comparator<Score>(){
                @Override
                public int compare(Score o1, Score o2) {
                    if(o1.allScores > o2.allScores){
                        return 1;
                    }else if(o1.yuwen > o2.yuwen){
                        return 1;
                    }else if(o1.shuxue > o2.shuxue){
                        return 1;
                    }else if(o1.yingyu == o2.yingyu){
                        return 0;
                    }
                    return 0;
                }
            });
            for(int j = 0 ;j < scores.size() ; j++){
                Score score = scores.get(j);
                System.out.println(String.format("%s %d %d %d",score.name,score.yuwen,score.shuxue,score.yingyu));
            }
        }
    }

}
