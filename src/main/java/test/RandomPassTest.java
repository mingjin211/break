package test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomPassTest {

  private static final String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
  private static final String[] uWord = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
  private static final String[] lWord = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
  //!@$%^-_=+[{}]:,./?
//    private static final String[] specialWord = {"!", "@", "#", "$", "%", "+", "^", "&", "*", "{", "[", "]", "}"};
  private static final String[] specialWord = {"!", "@", "$", "%", "^", "-", "_", "=", "+", "[", "{", "}", "]", ":", ",", ".", "/", "?"};
  //    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
  private static final DateFormat nameDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-S");

  /**
   * 规则：8-26位，必须包含大写字母、小写字母、数字、特殊字符(!@#$%+^&*{[]})四类中的三类
   * 不能包含用户名或用户名的逆序
   * Windows系统密码不能包含用户名中超过两个连续字符的部分
   * 用户名：linux: root, windows: Administrator
   * @param isWindows 是否是windows
   * @return
   */
  public static String randomAdminPass(boolean isWindows) {
    List<String[]> list = new ArrayList<>();
    list.add(nums);
    list.add(uWord);
    list.add(lWord);
    list.add(specialWord);

    List<Integer> randomIndexList = new ArrayList<>();
    randomIndexList.add(random(randomIndexList));
    randomIndexList.add(random(randomIndexList));
    randomIndexList.add(random(randomIndexList));

//        int lengh = new Random().nextInt(26) % 17 + 8; // 8 - 26 random.nextInt(max)%(max-min+1) + min;
    int lengh = 128; // 8 - 26 random.nextInt(max)%(max-min+1) + min;

    StringBuilder sb = new StringBuilder();
    for (int j = 0; j < randomIndexList.size(); j++) {
      Integer randomIndex = randomIndexList.get(j);
      int len = lengh / 3;
      if (j == randomIndexList.size() - 1) {
        len = lengh - 2 * len;
      }
      for (int i = 0; i < len; i++) {
        String[] words = list.get(randomIndex);
        sb.append(words[new Random().nextInt(words.length)]);
      }
    }
    return shuffStr(sb.toString(), null, isWindows);
  }
  private static Integer random(List<Integer> randomIndexList) {
    int randomIndex = new Random().nextInt(4);
    if (randomIndexList.contains(randomIndex)) return random(randomIndexList);
    return randomIndex;
  }
  private static String shuffStr(String str, StringBuilder stringBuilder, boolean isWindows) {
    if (null == stringBuilder) stringBuilder = new StringBuilder();
    if (str.length() == 0) {
      String finalStr = stringBuilder.toString();
      String userName = isWindows ? "Administrator" : "root";
      if (finalStr.contains(userName) || finalStr.contains(new StringBuilder(userName).reverse().toString())) {
        return randomAdminPass(isWindows);
      } else if (isWindows) {
        for (int i = 0; i <= userName.length() - 2; i++) {
          String subStr = userName.substring(i, i + 2);
          if (finalStr.contains(subStr)) return randomAdminPass(isWindows);
        }
      }
      return finalStr;
    }
    StringBuilder temp = new StringBuilder(str);
    int random = new Random().nextInt(temp.length());
    stringBuilder.append(temp.charAt(random));
    str = temp.deleteCharAt(random).toString();
    return shuffStr(str, stringBuilder, isWindows);
  }

  public static Boolean checkAdminPass(String password,boolean isWindows) {
    Pattern p = Pattern.compile(
            "(((?=.*[a-z])+(?=.*[A-Z])+(?=.*\\d)+)|((?=.*[A-Z])+(?=.*[a-z])+(?=.*[!@$%^/+=\\-\\[\\]{}?:,._])+)" +
                    "|((?=.*\\d)+(?=.*[A-Z])+(?=.*[!@$%^/+=\\-\\[\\]{}?:,._])+)" +
                    "|((?=.*\\d)+(?=.*[a-z])+(?=.*[!@$%^/+=\\-\\[\\]{}?:,._])+))[A-Za-z\\d!@$%^/+=\\-\\[\\]{}?:,._]{8,26}$");
    Matcher m = p.matcher(password);
    if(!m.find()) {
      return false;
    }
    List<String> keyWords;
    if(isWindows){
      keyWords = Arrays.asList("Administrator","rotartsinimdA","Adm","dmi","min","ini","nis","ist","str","tra","rat","ato","tor");
    }else{
      keyWords = Arrays.asList("root","toor");
    }
    for(String keyWord : keyWords){
      if(password.contains(keyWord)){
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args){
    int i=0;
    while (i<10){
      String pass = randomAdminPass(true);
      System.out.println(i + ":" + pass);
      if(!checkAdminPass(pass,true)){
        System.out.println(i + ":不符合");
        break;
      }
      //      System.out.println(i + ":" + new Random().nextInt(26) % 17 + 8);
      i++;
    }
  }


}
