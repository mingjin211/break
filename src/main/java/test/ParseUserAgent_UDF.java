package test;

import org.apache.hadoop.hive.ql.exec.UDF;
import org.apache.hadoop.io.Text;

import eu.bitwalker.useragentutils.UserAgent;

public class ParseUserAgent_UDF extends UDF{
  public Text evaluate(String userAgent){
    StringBuilder builder = new StringBuilder();
    UserAgent ua = new UserAgent(userAgent);
    builder.append(ua.getOperatingSystem()+"\t"+ua.getBrowser()+"\t"+ua.getBrowserVersion());
    return new Text(builder.toString());
  }

  public static void main(String args[]){
    ParseUserAgent_UDF parseUserAgent_udf = new ParseUserAgent_UDF();
    parseUserAgent_udf.evaluate("Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_2 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/15E148 MicroMessenger/7.0.8(0x17000820) NetType/WIFI Language/zh_CN");
  }
}