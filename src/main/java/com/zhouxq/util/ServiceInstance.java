package com.zhouxq.util;

/**
 * ������
 * @author Administrator
 *
 */
public class ServiceInstance implements Comparable<ServiceInstance> {
	
	  /** 
	    * @Fields orderId : ������
	    */ 
	    private int orderId;
	    /** 
	    * @Fields type : ��������
	    */ 
	    private Integer type;
	    /** 
	    * @Fields serviceName : ��������
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
