package com.zhouxq.service.impl;

import com.zhouxq.exception.CollectionException;
import com.zhouxq.param.PlanParam;
import com.zhouxq.service.ICollectionService;
import com.zhouxq.service.IGenerateCollectionPlan;
import com.zhouxq.service.ObjectFactory;

public class CollectionService implements ICollectionService {

	public void generateCollectionPlan(PlanParam planParam) throws CollectionException {
		IGenerateCollectionPlan generateCollectionPlan = ObjectFactory.getInstance().getCollectionPlanGenerator(planParam.getKey());
		generateCollectionPlan.genCollectionPlan(planParam);
	}

}
