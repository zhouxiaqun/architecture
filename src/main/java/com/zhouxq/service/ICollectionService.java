package com.zhouxq.service;

import com.zhouxq.exception.CollectionException;
import com.zhouxq.param.PlanParam;

public interface ICollectionService {
	
	public void generateCollectionPlan(PlanParam planParam) throws CollectionException;

}
