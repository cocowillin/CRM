package com.coco.crm.settings.services.Impl;

import com.coco.crm.settings.dao.UserDao;
import com.coco.crm.settings.services.UserService;
import com.coco.crm.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author radio
 * @create 2021-02-24 4:46 PM
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao= SqlSessionUtil.getSqlSession().getMapper(UserDao.class);
}
