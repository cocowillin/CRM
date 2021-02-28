package com.coco.crm.settings.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author radio
 * @create 2021-02-26 7:53 PM
 */
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("进入解决字符乱码过滤器");
        //过滤post中文乱码
        request.setCharacterEncoding("UTF-8");
        //过滤响应流乱码问题
        response.setContentType("text/html;charset=utd-8");
        chain.doFilter(request,response);//请求放行
    }
}
