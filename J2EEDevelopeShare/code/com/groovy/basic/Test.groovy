package com.groovy.basic

import static org.junit.Assert.*

class Test {

	@org.junit.Test
	public void test() {
		Book gina = new Book('Groovy in action')
		println gina.getTitle()
		println getTitleBackwards(gina)	
		assert '12345' =~ /\d+/
		assert 'xxxxx' == '12345'.replaceAll(/\d/, 'x')
		def x = 1
		def y = 2
		assert x + y == 3
		assert x.plus(y) == 3
		assert x instanceof Integer
		def roman = ['','I','II','III','IV','V','VI','VII']
		println roman[4]
		roman[8] = 'VIII' //支持动态扩展
		println roman.size()
		roman.each{
			println "Element is : $it"
		}
		def http = [
			100 : 'CONTINUE',
			200 : 'OK',
			400 : 'BAD REQUEST'
		]
		println http[200]
		http[500] = 'INTERNAL SERVER ERROR'
		println 'Maps size is : ' + http.size()
	}

	@org.junit.Test
	public void test2() {
		//comment
		def x = 1..10
		assert x.contains(5) == false
		assert x.contains(15) == false
		assert x.size() == 10
		assert x.from == 1
		assert x.to == 10
		assert x.reverse() == 10..1
		x.each{
			println "Element is : $it"
		}
	}
	
	@org.junit.Test
	public void test3() {
		if(false)
		println 'false'
	else
		println 'true'
	
	if(null)
		println 'null object'
	else	
		println 'is not null'
		
	def i = 0
	while(i < 10){
		i++
	}
	println "i is : $i"
	
	def clinks = 0
	
	for(rg in 0..9){
		clinks += rg
	}
	println "Clinks is : $clinks"
	
	def list = [0,1,2,3,4,5,6,7,8,9]
	for(j in list){
		println(list[j])
	}
	
	list.each{ item ->
		println "Item is : $item"
	}
	
	switch(3){
		case 1: 
			println 'number is 1'
			break
		case 3:
			println 'number is 3'
			break
		default:
			println 'no value is right'
			break
	}
	}

	String getTitleBackwards(book){
		def title = book.getTitle()
		return title.reverse()
	}
}