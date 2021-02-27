package com.coco.crm.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.apache.ibatis.session.SqlSession;

public class TransactionInvocationHandler implements InvocationHandler{
	
	private Object target;//目标对象；

	public TransactionInvocationHandler(Object target) {
		this.target = target;
	}


	
	public Object getProxy(){
		
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
		//取得代理类对象；
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

		SqlSession session = null;

		Object obj=null ;//引用数据类型 未赋值的情况下为null;

		try{
			session = SqlSessionUtil.getSqlSession();

			obj = method.invoke(target, args);

			session.commit();//提交事务
		}catch(Exception e){
			session.rollback();
			e.printStackTrace();

			//处理的是什么异常，继续往上抛什么异常
			throw e.getCause();//这里很重要;
		}finally{
			SqlSessionUtil.myClose(session);
		}

		return obj;
	}
	
}











































