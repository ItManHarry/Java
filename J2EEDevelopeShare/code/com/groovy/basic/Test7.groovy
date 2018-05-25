package com.groovy.basic

import static org.junit.Assert.*

import org.junit.Test

class Test7 {

	@Test
	public void test() {
		def b = true
		println b
		def l = []
		if(l){
			println "list is not empty"
		}else{
			println "list is empty"
		}
		WeekDay wk 
		if(wk){
			println "wk is not null"
		}else{
			println "wk is null"
		}
		def i = 0
		if(i){
			println "the number is not zero"
		}else{
			println "the number is zero"
		}
		def m = [:]
		if(m){
			println "map is not empty"
		}else{
			println "map is empty"
		}
		def number = i ? 10 : 0
		println number
		def name = 'Sam'
		switch(name){
			case 'Jack':
				println "Jack..."
				break
			case 'Harry':
				println "Harry..."
				break
			default:
				println "No name"
				break
		}
		i = 15
		switch(i){
			case 0..10:
				println 'one...'
				break
			case 10..20:
				println 'two...'
				break
			case 20..30:
				println 'three...'
				break
			default:
				println 'bad number'
				break
		}
		while(i > 5){
			println "i is : $i"
			i--
		}
		def str = 'Harrycheng'
		def list = [1,2,3,4,5,6,7,8,9]
		for(s in str){
			println s
		}
		for(n in list){
			if(n == 4)
				continue
			else if(n ==7)
				break
			else
				println "Number is : $n"
			
		}
	}
}
