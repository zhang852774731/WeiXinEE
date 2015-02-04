package com.ccs.zhang.reqmsg;

/**
 * Created by Administrator on 2015/1/23.
 * 接收消息基类
 */
public class BaseReqMessage {
    //开发者微信号
    private String ToUserName;
    //发送方账号
    private String FromUserName;
    //消息创建时间
    private Long CreateTime;
    //消息类型
    private String MsgType;
    //消息id，64位整型
    private long MsgId;

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

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }
}
