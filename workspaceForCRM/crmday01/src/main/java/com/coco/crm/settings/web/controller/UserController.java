package com.coco.crm.settings.web.controller;

import com.coco.crm.settings.domain.User;
import com.coco.crm.settings.services.Impl.UserServiceImpl;
import com.coco.crm.settings.services.UserService;
import com.coco.crm.utils.MD5Util;
import com.coco.crm.utils.PrintJson;
import com.coco.crm.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author radio
 * @create 2021-02-24 4:52 PM
 */
public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        System.out.println("进入用户控制器");
        String path = req.getServletPath();//获得url pattern
        if ("/settings/user/login.do".equals(path)){
                //登录方法执行
                login(req,resp);

        }else if ("/settings/user/xxx.do".equals(path)){
                //xxx.方法执行

        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
            System.out.println("进入登录验证操作");
            //获取账号和密码
            String loginAct = req.getParameter("loginAct");
            String loginPwd = req.getParameter("loginPwd");

            //将密码明文转换为md5；
            loginPwd = MD5Util.getMD5(loginPwd);
            //获取ip地址；
            String ip = req.getRemoteAddr();
            //输出到控制台ip是什么
            System.out.println("ip-----------" + ip);
            //业务开发统一代理类接口对象
            UserService service = (UserService) ServiceFactory.getService(new UserServiceImpl());
            try {
                System.out.println("这里执行了吗");
                User user = service.login(loginAct, loginPwd, ip);
                //把获得的对象放入session中
                System.out.println("是否执行到这了");
                req.getSession().setAttribute("user", user);
                System.out.println("登录成功了");
                //如果程序执行到此处，说明程序业务层没有为controller抛出任何异常
                /*
                * 返回{"success" :true}
                * */
                PrintJson.printJsonFlag(resp,true);
            } catch (Exception e) {
                System.out.println("登录失败");
                e.printStackTrace();
                //执行到catchy语句块中，说明业务层为我们验证登录失败，抛出异常
                String msg=e.getMessage();
                System.out.println(msg);
                Map<String, Object> map = new HashMap<>();
                map.put("success",false);
                map.put("msg",msg);
                PrintJson.printJsonObj(resp,map);
            }


    }
}
