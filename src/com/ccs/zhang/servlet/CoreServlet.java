package com.ccs.zhang.servlet;

import com.ccs.zhang.service.CoreService;
import com.ccs.zhang.util.SignUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015/1/23.
 */
public class CoreServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String signature = req.getParameter("signature");
        String timestamp = req.getParameter("timestamp");
        String nonce = req.getParameter("nonce");
        String echostr = req.getParameter("echostr");
        String token = "weixin";
        PrintWriter writer = resp.getWriter();
        if(signature.equals(SignUtil.checkSignature(token,timestamp,nonce))){
            writer.write(echostr);
        }
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        req.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        String result = CoreService.process(req);
        PrintWriter writer = resp.getWriter();
        writer.write(result);
        writer.close();
    }
}
