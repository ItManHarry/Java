package com.groovy.classes

class MethodClosure {
	
	MethodClosure(int limit){
		this.limit = limit;
	}
	
	boolean validate(String v){
		return v.length() <= limit;
	}
	
	def doubleValue(Map map){
		return map.each { k, v ->
			map[k] = v * 2;
		}
	}
	
	int limit;
}