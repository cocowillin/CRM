package com.coco.crm.exception;

/**
 * @author radio
 * @create 2021-02-25 11:29 PM
 */
public class LoginException  extends Exception{
    public LoginException(String message) {
        super(message);
    }//有参构造 不要无参
}
