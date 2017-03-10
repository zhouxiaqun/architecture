package com.zhouxq.util;

/**
 * 获取Spring容器中的service bean
 * @author Administrator
 *
 */
public final class ServiceHelper {
	
	public static Object getService(String serviceName) {
		return Constants.WEB_APP_CONTEXT.getBean(serviceName);
	}

}
