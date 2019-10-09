package test;

public class D04_CodePoint {
    public static void main(String[] args){
        /*
         * .字符串由char值序列组成，char是使用UTF-16编码表示Unicode码点的代码单元。
         * .大多数的常用Unicode字符使用一个代码单元就可以表示，而辅助字符需要一对代码单元表示
         * */
        {
            String str = "hello世界";
            System.out.println("代码单元数量：" + str.length());

            //码点操作
            System.out.println("码点数量：" + str.codePointCount(0, str.length()));
            //字符串转换成码点序列
            int[] codePoints = str.codePoints().toArray();
            //遍历码点序列
            for(int i=0 ; i<codePoints.length ; i++){
                System.out.println(codePoints[i]);
            }
            //根据码点创建字符串
            String str2 = new String(codePoints, 0, codePoints.length);
            System.out.println(str2);
        }

    }
}
