package com.zhouxq.util;

/**
 * ��ȡSpring�����е�service bean
 * @author Administrator
 *
 */
public final class ServiceHelper {
	
	public static Object getService(String serviceName) {
		return Constants.WEB_APP_CONTEXT.getBean(serviceName);
	}

}
