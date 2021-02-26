package com.coco.crm.utils;

public class ServiceFactory {
	
	public static Object getService(Object service){
		
		return new TransactionInvocationHandler(service).getProxy();
		//传入张三对象 返回李四对象；
	}
	
}
