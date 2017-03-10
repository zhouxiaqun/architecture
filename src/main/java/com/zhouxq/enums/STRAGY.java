package com.zhouxq.enums;

public enum STRAGY {
	
	ONE(1,"serviceOne"),
	TWO(2,"serviceTwo"),
	THREE(3,"serviceThree");
	
	private Integer value;
	
	private String title;
	
	STRAGY(Integer value,String title){
		this.value = value;
		this.title = title;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public static STRAGY parse(Integer value){
		for(STRAGY state:STRAGY.values()){
			if(state.value.equals(value)){
				return state;
			}
		}
		return null;
	}

}
