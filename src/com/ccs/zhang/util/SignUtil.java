package com.ccs.zhang.util;

import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Created by Administrator on 2015/1/23.
 */
public class SignUtil {
    public static String checkSignature(String token,String timestamp,String nonce){
        String arr[] = new String[] {token,timestamp,nonce};
        Arrays.sort(arr);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        MessageDigest messageDigest = null;
        String digestResult = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] digestByte = messageDigest.digest();
            digestResult = byteToStr(digestByte);
        }catch (Exception e){
            e.printStackTrace();
        }
        return digestResult;
    }

    public static String byteToStr(byte[] digestByte){
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<digestByte.length;i++){
            buffer.append(byteToHexStr(digestByte[i]));
        }
        return buffer.toString();
    }

    public static String byteToHexStr(byte mByte){
        char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        char[] tempArr = new char[2];
        tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
        tempArr[1] = Digit[mByte & 0X0F];
        String s = new String(tempArr);
        return s;
    }
}
