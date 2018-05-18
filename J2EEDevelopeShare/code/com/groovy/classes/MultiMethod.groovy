package com.groovy.classes

class MultiMethod {
	int getResult(String v){
		return v.length();
	}
	
	int getResult(List list){
		return list.size();
	}
	
	int getResult(int x, int y){
		return x + y;
	}
}
