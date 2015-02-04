package com.ccs.zhang.reqmsg;

/**
 * Created by Administrator on 2015/1/23.
 */
public class LocationReqMessage extends BaseReqMessage {
    private String Location_X;
    private String Location_Y;
    //地图缩放大小
    private String Scale;
    //地理位置信息
    private String Label;

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
