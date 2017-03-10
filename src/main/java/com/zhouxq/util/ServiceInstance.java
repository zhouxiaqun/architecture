package com.zhouxq.util;

/**
 * 服务定义
 * @author Administrator
 *
 */
public class ServiceInstance implements Comparable<ServiceInstance> {
	
	  /** 
	    * @Fields orderId : 排序用
	    */ 
	    private int orderId;
	    /** 
	    * @Fields type : 服务类型
	    */ 
	    private Integer type;
	    /** 
	    * @Fields serviceName : 服务名称
	    */ 
	    private String serviceName;
	    
	    public ServiceInstance() {
	        
	    }

	    public ServiceInstance(String serviceName) {
	        this.serviceName = serviceName;
	    }

	    public ServiceInstance(String serviceName, Integer type, int orderId) {
	        this.orderId = orderId;
	        this.type = type;
	        this.serviceName = serviceName;
	    }

	    public int getOrderId() {
	        return orderId;
	    }
	    
	    public void setOrderId(int orderId) {
	        this.orderId = orderId;
	    }
	    
	    public Integer getType() {
	        return type;
	    }
	    
	    public void setType(Integer type) {
	        this.type = type;
	    }
	    
	    public String getServiceName() {
	        return serviceName;
	    }
	    
	    public void setServiceName(String serviceName) {
	        this.serviceName = serviceName;
	    }

	    public int compareTo(ServiceInstance o) {
	        return orderId-o.orderId;
	    }

}
