package com.ccs.zhang.reqmsg;

/**
 * Created by Administrator on 2015/1/23.
 */
public class VoiceReqMessage extends BaseReqMessage {
    //语音消息媒体id
    private String MediaId;
    //语音格式，如amr，speex等
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
