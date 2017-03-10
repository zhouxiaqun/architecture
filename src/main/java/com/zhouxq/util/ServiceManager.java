package com.zhouxq.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 服务注册管理
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
            LOGGER.error("不存在的服务对象:" + key);
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
                LOGGER.error("不存在的服务对象:" + serviceName);
                return null;
            }

            if (!tClass.isInstance(service)) {
                LOGGER.error("服务对象["+service.getClass().getCanonicalName()+"]未实现["+tClass.getCanonicalName()+"]接口");
                throw new ClassCastException(
                        "服务对象["+service.getClass().getCanonicalName()+"]未实现["+tClass.getCanonicalName()+"]接口");
            }
            return tClass.cast(service);
        }
    }

    /** 
    * @Title: registerServiceInstance 
    * @Description: 注册服务
    * @param @param key
    * @param @param serviceInstance    设定文件 
    * @return void    返回类型 
    * @throws 
    */
    public void registerServiceInstance(String key, Object serviceInstance) {
        LOGGER.info("注册的服务对象[" + key + ":" + serviceInstance + "]");
        if (null == serviceInstance) {
            LOGGER.error("注册的服务对象为空[" + key + "]");
            return;
        }

        serviceMapper.put(key, serviceInstance);
    }

}
