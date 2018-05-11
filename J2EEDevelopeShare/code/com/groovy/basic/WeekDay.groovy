package com.groovy.basic

class WeekDay implements Comparable {
	static final DAYS = [
			'Sun','Mon','Tue','Wed','Thu','Fri','Sat'
		]
		
	private int index = 0
	
	WeekDay(String day){
		index = DAYS.indexOf(day)
	}
	
	WeekDay next(){
		return new WeekDay(DAYS[(index+1)%DAYS.size()])
	}
	
	WeekDay previouse(){
		return new WeekDay(DAYS[index-1])
	}
	
	int compareTo(Object other){
		return this.index <=> other.index
	}
	
	String toString(){
		return DAYS[index]
	}
	
}
