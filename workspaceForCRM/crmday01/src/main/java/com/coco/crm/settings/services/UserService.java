package com.coco.crm.settings.services;

import com.coco.crm.exception.LoginException;
import com.coco.crm.settings.domain.User;

/**
 * @author radio
 * @create 2021-02-24 4:45 PM
 */
public interface UserService {

    User login(String loginAct, String loginPwd, String ip) throws LoginException;
}
