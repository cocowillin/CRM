package com.coco.crm.settings.dao;

import com.coco.crm.settings.domain.User;

import java.util.Map;

/**
 * @author radio
 * @create 2021-02-24 4:41 PM
 */
public interface UserDao {

    User login(Map<String, String> map);

}
