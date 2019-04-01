package test;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class Jsontransefer {

    public static void main(String[] args) {


        Map<String,Integer> has = new LinkedHashMap<>();
        Map<String, Integer> result = new LinkedHashMap<>();
        has.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .reversed()).forEachOrdered(e -> result.put(e.getKey(), e.getValue()));

        ReceiveChatRes receiveChatRes = new ReceiveChatRes();
        receiveChatRes.setMsgId("123");

        try {
            System.out.println(new ObjectMapper().writeValueAsString(receiveChatRes));
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
