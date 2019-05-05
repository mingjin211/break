package test;


import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * app接收在线客服传递消息请求
 * @auther ghb
 * @date 2018/12/13 16:11
 */
public class ReceiveChatRes {

    @JsonProperty( "MsgId")
    private String MsgId;
    private String status;
    private String eventKey;
    private String answerPat;
    private List<String> menuItems;

    @JsonIgnore
    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        this.MsgId = msgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getAnswerPat() {
        return answerPat;
    }

    public void setAnswerPat(String answerPat) {
        this.answerPat = answerPat;
    }

    public List<String> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<String> menuItems) {
        this.menuItems = menuItems;
    }

}

