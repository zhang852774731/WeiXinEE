package com.ccs.zhang.service;

import com.ccs.zhang.resmsg.TextResMessage;
import com.ccs.zhang.util.MessageUtil;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2015/1/23.
 */
public class CoreService {
    public static String process(HttpServletRequest request){
        String respContent = "请求处理异常，请稍后再试";
        Map<String,String> requestMap = MessageUtil.parseXML(request);
        String fromUserName = requestMap.get("FromUserName");
        String toUserName = requestMap.get("ToUserName");
        String msgType = requestMap.get("MsgType");
        if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
            respContent = "你发送的文本消息";
        }
        // 图片消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
            respContent = "您发送的是图片消息！";
        }
        // 地理位置消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
            respContent = "您发送的是地理位置消息！";
        }
        // 链接消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
            respContent = "您发送的是链接消息！";
        }
        // 音频消息
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
            respContent = "您发送的是音频消息！";
        }
        // 事件推送
        else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
            // 事件类型
            String eventType = requestMap.get("Event");
            // 订阅
            if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                respContent = "谢谢您的关注！";
            }
            // 取消订阅
            else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
            }
            // 自定义菜单点击事件
            else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                // TODO 自定义菜单权没有开放，暂不处理该类消息
            }
        }
        TextResMessage textResMessage = new TextResMessage();
        textResMessage.setFromUserName(toUserName);
        textResMessage.setToUserName(fromUserName);
        textResMessage.setContent(respContent);
        textResMessage.setMsgType(MessageUtil.REQ_MESSAGE_TYPE_TEXT);
        textResMessage.setCreateTime(new Date().getTime());
        String toXml = MessageUtil.textResMessageToXml(textResMessage);
        return toXml;
    }
}
