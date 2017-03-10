package com.zhouxq.service;

import com.zhouxq.exception.CollectionException;
import com.zhouxq.param.PlanParam;

public interface IGenerateCollectionPlan {

	public void genCollectionPlan(PlanParam planParam) throws CollectionException;
}
