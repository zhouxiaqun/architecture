package com.zhouxq.exception;

public class CollectionException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5085819980182059740L;
	
	public CollectionException(){
		super();
	}
	
	public CollectionException(String msg){
		super(msg);
	}
	
	public CollectionException(Throwable t){
		super(t);
	}
	
	public CollectionException(String msg,Throwable t){
		super(msg, t);
	}

}
