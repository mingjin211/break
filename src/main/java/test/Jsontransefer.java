package test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsontransefer {

    public static void main(String[] args) {

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
