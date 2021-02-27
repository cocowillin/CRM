package com.coco.crm.utils;

public class ServiceFactory {
	
	public static Object getService(Object service){//静态方法和静态属性直接通过类名点访问
		
		return new TransactionInvocationHandler(service).getProxy();
		//传入张三对象 返回李四对象；
	}
	
}
