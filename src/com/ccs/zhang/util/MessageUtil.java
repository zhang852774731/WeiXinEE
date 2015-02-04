package com.ccs.zhang.util;

import com.ccs.zhang.resmsg.MusicResMessage;
import com.ccs.zhang.resmsg.NewsResMessage;
import com.ccs.zhang.resmsg.TextResMessage;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**消息工具类
 * Created by Administrator on 2015/1/23.
 */
public class MessageUtil {

    /**
     * 返回消息类型：文本
     */
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String RESP_MESSAGE_TYPE_NEWS = "news";

    /**
     * 请求消息类型：文本
     */
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    /**
     * 请求消息类型：图片
     */
    public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String REQ_MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：音频
     */
    public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：推送
     */
    public static final String REQ_MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";
    /**
     *
     * @param req
     * @return
     * 解析xml数据
     */
    public static Map<String,String> parseXML(HttpServletRequest req){
        Map<String,String> map = new HashMap<String, String>();
        try {
            InputStream inputStream = req.getInputStream();
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> elementList = root.elements();
            for(Element element : elementList){
                map.put(element.getName(),element.getText());
            }
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


    /**
     *文本消息对象转换成xml
     */
    public static String textResMessageToXml(TextResMessage textResMessage){
        xstream.alias("xml", textResMessage.getClass());
        return xstream.toXML(textResMessage);
    }

    /**
     *
     * @param musicResMessage
     * @return
     * 音乐消息对象转换成xml
     */
    public static String musicMessageToXml(MusicResMessage musicResMessage){
        xstream.alias("xml",musicResMessage.getClass());
        return xstream.toXML(musicResMessage);
    }

    /**
     *
     * @param newsResMessage
     * @return
     * 图文消息对象转换成xml
     */
    public static String newsMessageToXml(NewsResMessage newsResMessage){
        xstream.alias("xml",newsResMessage.getClass());
        return xstream.toXML(newsResMessage);
    }

    /**
     * 扩展xstream，使其支持CDATA块
     *
     * @date 2013-05-19
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }

                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**计算回复消息的长度，所占字节数
     *微信对消息长度限制为2048
     */
    public static int getByteSize(String messageContent){
        int size = 0;
        if(null != messageContent) {
            try {
                size = messageContent.getBytes("utf-8").length;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return size;
    }

    /**当用户输入？时，返回menu菜单
     *
     */
    public static String getMainMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("您好，我是椰子船长，请回复数字选择数字：").append("\n\n");
        sb.append("1    天气预报").append("\n");
        sb.append("2    公交查询").append("\n");
        sb.append("3    周边搜索").append("\n");
        sb.append("4    经典游戏").append("\n");
        sb.append("5    歌曲点播").append("\n");
        sb.append("6    美女电台").append("\n");
        sb.append("7    人脸识别").append("\n\n");
        sb.append("回复“？”显示此帮助菜单!");
        return sb.toString();
    }
}
