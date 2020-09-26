package com.yuanzh;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet("/demo2")
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); //解决中文乱码

        String contextPath = request.getContextPath();
        System.out.println("contextPath " + contextPath);

        String requestURI = request.getRequestURI();
        System.out.println("requestUri " + requestURI);

        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestUrL " + requestURL);

        String protocol = request.getProtocol();
        System.out.println("protocol="+protocol);
        // 获取所有请求头
        Enumeration<String> headerNames = request.getHeaderNames();

        while(headerNames.hasMoreElements()){
            String name = headerNames.nextElement();
            String header = request.getHeader(name);
            System.out.println(name+"---"+header);

        }
        // 获取user-agent 客户端浏览器类型
        String agent = request.getHeader("user-agent");
        if(agent.contains("Chrome")) {
            System.out.println("chrome ing...");
        }
        // 获取referer--告诉浏览器从哪里来
        String ref = request.getHeader("referer");
        System.out.println("referer="+ref);
        if(ref!=null) {
            if(ref.contains("/demo2")){
                System.out.println("ref ok..");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("ref是ok的");
            }else {
                System.out.println("盗链...");
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write("盗链...");
            }
        }
        System.out.println("***********************************");
        /*
        获取请求体，只有post才有
         */
        // 方式1： 获取字符流
//        BufferedReader br = request.getReader();
//        String line = null;
//        while((line=br.readLine())!=null) {
//            System.out.println(line);
//        }

        // 方式2： 获取请求参数 上面的请求体为： username=?&password=?
        System.out.println("usrname=" + request.getParameter("username"));
        System.out.println("password=" + request.getParameter("password"));

        // 获取所有请求名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while(parameterNames.hasMoreElements()){
            String s = parameterNames.nextElement();
            System.out.println(s+" : "+ request.getParameter(s));
        }


        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet = parameterMap.keySet();
        for(String name: keySet) {
            String[] values = parameterMap.get(name);
            for(String value: values){
                System.out.println(name + " = " + value);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
