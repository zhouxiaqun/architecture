package com.zhouxq.service.impl;

import com.zhouxq.exception.CollectionException;
import com.zhouxq.param.PlanParam;
import com.zhouxq.service.IGenerateCollectionPlan;

public class TwoCollectionPlanGenerator implements IGenerateCollectionPlan {

	public void genCollectionPlan(PlanParam planParam) throws CollectionException {
		System.out.println("do something two...");
	}

}
