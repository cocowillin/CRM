package com.coco.crm.settings.services.Impl;

import com.coco.crm.exception.LoginException;
import com.coco.crm.settings.dao.UserDao;
import com.coco.crm.settings.domain.User;
import com.coco.crm.settings.services.UserService;
import com.coco.crm.utils.DateTimeUtil;
import com.coco.crm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * @author radio
 * @create 2021-02-24 4:46 PM
 */
public class UserServiceImpl implements UserService {
        private UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);

        @Override
        public User login(String loginAct, String loginPwd, String ip) throws LoginException {
                System.out.println("进入事务层开始调用dao层处理");
                Map<String, String> map = new HashMap<>();
                map.put("loginAct",loginAct);
                map.put("loginPwd",loginPwd);
                User user=userDao.login(map);
                if(user==null){
                        //没有找到user对象
                   throw new LoginException("账号密码错误");
                }
                String expireTime=user.getExpireTime();
                String currentTime= DateTimeUtil.getSysTime();
                if (expireTime.compareTo(currentTime)<0){
                    throw new LoginException("您的账号已经失效，请联系管理员");
                }
                String lockState=user.getLockState();
                if (Integer.valueOf(lockState)==0){
                        throw new LoginException("您的账号已经被锁定,请联系管理员");
                }

                String allowIps = user.getAllowIps();//
                if (!allowIps.contains(ip)){//contains的用法
                        throw new LoginException("ip受限，请联系管理员");
                }

                return user;

        }
}
