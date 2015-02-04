package com.ccs.zhang.resmsg;

/**
 * Created by Administrator on 2015/1/23.
 * 回复消息基类
 */
public class BaseResMessage {
    //接收方帐号（收到的OpenID）
    private String ToUserName;
    //开发者微信号
    private String FromUserName;
    //消息创建时间
    private Long CreateTime;
    //消息类型（text/music/news）
    private String MsgType;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public Long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(Long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }
}
