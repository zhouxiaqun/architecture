package com.zhouxq.service;

import com.zhouxq.enums.STRAGY;
import com.zhouxq.util.ServiceManager;

public class ObjectFactory {
	
	private ServiceManager<IGenerateCollectionPlan> collectionPlanManger 
				= new ServiceManager<IGenerateCollectionPlan>(IGenerateCollectionPlan.class);
	
	private static ObjectFactory instance;
	
	private ObjectFactory(){
		registerAll();
	}
	
	private void registerAll(){
		collectionPlanManger.registerServiceInstance(STRAGY.ONE.getTitle(), "oneCollectionPlanGenerator");
		collectionPlanManger.registerServiceInstance(STRAGY.TWO.getTitle(), "twoCollectionPlanGenerator");
		collectionPlanManger.registerServiceInstance(STRAGY.THREE.getTitle(), "threeCollectionPlanGenerator");
	}
	
	public static ObjectFactory getInstance(){
		if(null == instance){
			synchronized (ObjectFactory.class) {
				if(null == instance){
					instance = new ObjectFactory();
				}
			}
		}
		return instance;
	}
	
	public void registerCollectionPlanGenerator(String key,Object serviceInstance){
		collectionPlanManger.registerServiceInstance(key, serviceInstance);
	}
	
	public IGenerateCollectionPlan getCollectionPlanGenerator(String key){
		return collectionPlanManger.getServiceInstance(key);
	}

}
