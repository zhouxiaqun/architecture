package com.zhouxq.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * ����ע�����
 * @author Administrator
 *
 * @param <T>
 */
public class ServiceManager <T> {
	
	private final static Logger LOGGER = Logger.getLogger(ServiceManager.class);

    private Class<T> tClass;
    private Map<String, Object> serviceMapper 
            = new HashMap<String, Object>();

    public ServiceManager(Class<T> tClass) {
        this.tClass = tClass;
    }

    public T getServiceInstance(String key) {
        Object serviceObj = serviceMapper.get(key);
        if (null==serviceObj) {
            LOGGER.error("�����ڵķ������:" + key);
            return null;
        }

        if (tClass.isInstance(serviceObj)) {
            return tClass.cast(serviceObj);
        } else {
            String serviceName = "";
            if (serviceObj instanceof ServiceInstance) {
                serviceName = ((ServiceInstance)serviceObj).getServiceName();
            } else {
                serviceName = String.valueOf(serviceObj);
            }
            Object service = ServiceHelper.getService(serviceName);
            if (null==service) {
                LOGGER.error("�����ڵķ������:" + serviceName);
                return null;
            }

            if (!tClass.isInstance(service)) {
                LOGGER.error("�������["+service.getClass().getCanonicalName()+"]δʵ��["+tClass.getCanonicalName()+"]�ӿ�");
                throw new ClassCastException(
                        "�������["+service.getClass().getCanonicalName()+"]δʵ��["+tClass.getCanonicalName()+"]�ӿ�");
            }
            return tClass.cast(service);
        }
    }

    /** 
    * @Title: registerServiceInstance 
    * @Description: ע�����
    * @param @param key
    * @param @param serviceInstance    �趨�ļ� 
    * @return void    �������� 
    * @throws 
    */
    public void registerServiceInstance(String key, Object serviceInstance) {
        LOGGER.info("ע��ķ������[" + key + ":" + serviceInstance + "]");
        if (null == serviceInstance) {
            LOGGER.error("ע��ķ������Ϊ��[" + key + "]");
            return;
        }

        serviceMapper.put(key, serviceInstance);
    }

}
