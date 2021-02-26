package com.coco.crm.settings.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author radio
 * @create 2021-02-24 4:52 PM
 */
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入用户控制器");
        String path = req.getServletPath();//获得url pattern
        if ("/settings/user/xxx.do".equals(path)){
                //xxx.方法执行
        }else if ("/settings/user/xxx.do".equals(path)){
                //xxx.方法执行

        }

    }
}
