package com.ccs.zhang.servlet;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/1/26.
 */
public class GetSignature extends HttpServlet{

    private String AppID = "wxb5b3a6d745623209";
    private String AppSecret="d50289585dc9c93ee84a7ac2b77548a5";
    private String getTokenURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.write(getToken());
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public String getToken(){
        String getTokenURL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential"
                + "&appid=" +AppID
                + "&secret=" + AppSecret;
        String result = "";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(getTokenURL);
        try{
            CloseableHttpResponse response = httpclient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                result = EntityUtils.toString(response.getEntity());
                System.out.println(result);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

