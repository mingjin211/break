package test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Jsontransefer {

//    public static void main(String[] args) {
//
//
//        Map<String,Integer> has = new LinkedHashMap<>();
//        Map<String, Integer> result = new LinkedHashMap<>();
//        has.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue()
//                        .reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
//
//        ReceiveChatRes receiveChatRes = new ReceiveChatRes();
//        receiveChatRes.setMsgId("123");
//
//        try {
//            System.out.println(new ObjectMapper().writeValueAsString(receiveChatRes));
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str = "{    \"param\":{        \"productId\":\"10025238\",        \"problemContent\":\"账号注销\",        \"problemTitle\":\"账号注销\",        \"productType\":\"会员账号\" },  \"webLink\":\"/workorder/submit\",    \"webOpen\":true,    \"link\":\"ctyun-login://workorderlist/submitWork\",    \"iconUrl\":\"https://app.ctyun.cn/static/images/console-tools/zhuxiao.png\",   \"webLinkType\":\"domain\",    \"title\":\"账户注销\",    \"type\":\"native\",    \"open\":true}";
//        ManagerToolBean json = new org.json.JSONObject(str,ManagerToolBean.class);
//        System.out.println("123123");

        System.out.println(URLEncoder.encode("https://app.ctyun.cn/app/index.html#/cloudMarket","UTF-8"));
    }

}
