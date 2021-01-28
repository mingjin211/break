package moveon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 字符串排序
 * 时间限制： 3000MS
 * 内存限制： 589824KB
 * 题目描述：
 * 字符串通常按字典顺序排序。这意味着它们通过比较最左边的不同字符来排序。例如，abc<abd因为c<d，同样z>yyy因为z>y。
 * 如果一个字符串是另一个的精确前缀，则在字典上更小，例如:gh<ghij。
 * 输入拥有n个字符串的数组s，请按严格的字典顺序打印其所有可能的排列组合。如果两个排列看起来相同，则仅打印其中一个。
 *
 *
 *
 * 输入描述
 * 每个测试文件的第一行包含一个整数，即字符串数组s的长度。 接下来的n行中的每行包含一个字符串s [i]。 约束条件 .2<=n<=9 .l<=s[i]<=10 .s[i]仅包含小写英文字母。
 *
 * 输出描述
 * 在一行上将每个排列打印为以空格分隔的字符串列表。
 *
 *
 * 样例输入
 * 2
 * ab
 * cd
 * 样例输出
 * ab cd
 * cd ab
 *
 * 提示
 * 有关示例，请参见下面的例子。
 * 例如n=3，s=[ab,bc,cd]，则输入：
 *
 * 3
 *
 * ab bc cd
 *
 * 应输出的六个排列的正确顺序是：
 *
 * ab bc cd
 *
 * ab cd bc
 *
 * bc ab cd
 *
 * bc cd ab
 *
 * cd ab bc
 *
 * cd bc ab
 *
 * 注意：可能有两个或多个相同的字符串与s的元素。
 *
 * 例如，s = [ab，ab，bc]。仅打印所有元素都匹配的排列组合实例。 换句话说，如果s [0] == s [1]，则打印s [0] s [1]或s [1] s [0]，但不能同时打印。
 *
 * 如上所述，具有三个离散元素的三元素数组具有六个排列组合。 在这种情况下，存在三对匹配的排列对，其中s [0] = ab和s [1] = ab被切换。 我们仅打印三个明显独特的排列组合：
 *
 * ab ab bc
 *
 * ab bc ab
 *
 * bc ab ab​
 */
public class One {

    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n;
        n = cin.nextInt();
        ArrayList<String> input = new ArrayList<>();
        // 读取接下来n行
        for (int i = 0; i < n; i++) {
            // 读取每行的字符串
            input.add(cin.next());
        }
        LinkedList<String> tmp = new LinkedList<>();
        ArrayList<LinkedList<String>> result = new ArrayList<>();
        boolean[] used = new boolean[input.size()];
        Collections.sort(input);
        dfs(0,used,input,tmp,result);
        for(int i = 0 ; i < result.size() ; i++){
            LinkedList<String> cur = result.get(i);
            for(int j = 0 ; j < cur.size() ;j++){
                System.out.print(cur.get(j));
                if(j == cur.size()-1){
                    System.out.println("");
                }else{
                    System.out.print(" ");
                }
            }
        }
    }

    static void dfs(int d,boolean[] used,ArrayList<String> input,LinkedList<String> tmp,ArrayList<LinkedList<String>> result){
        if(input.size()==tmp.size()){
            LinkedList<String> tt = new LinkedList<>(tmp);
            result.add(tt);
            return;
        }
        for(int i = 0 ; i < input.size() ; i++){
            if(used[i]){
                continue;
            }
            if(i > 0 && input.get(i).equals(input.get(i-1)) && !used[i-1]){
                continue;
            }
            used[i] = true;
            tmp.addLast(input.get(i));
            dfs(d,used,input,tmp,result);
            tmp.removeLast();
            used[i] = false;
        }
    }

}
