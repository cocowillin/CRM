package com.coco.settings.test;







import com.coco.crm.settings.dao.UserDao;
import com.coco.crm.settings.domain.User;
import com.coco.crm.utils.MD5Util;
import com.coco.crm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    @Test
    //验证不通过前端传值，直接mybatis传值测试；
    public void select(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserDao dao = sqlSession.getMapper(UserDao.class);
        Map<String, String> map = new HashMap<>();
        map.put("loginAct","zs");
        String psw="123";
        psw= MD5Util.getMD5(psw);
        map.put("loginPwd",psw);
        User user = dao.login(map);
        System.out.println(user);

    }


  /*  private static final Log log = LogFactory.getLog(Test1.class);

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }
    @Test
    public void testJsonPrint() {
            String msg = "账号密码错误";
            Map<String, Object> map = new HashMap<>();
            map.put("success", false);
            map.put("msg", msg);


        }*/
  /*  @Test
    public void test(){



        //request.setRequestURI("/loginCheck.html");
        //直接添加request参数，相当简单
        String msg="直接打印错误";
        Map<String, Object> map = new HashMap<>();
        map.put("success",false);
        map.put("msg",msg);
        String jsonObj = PrintJson.printJsonObj(response, map);
        System.out.println(jsonObj);


    }*/

}
