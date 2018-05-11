package com.groovy.basic
import static org.junit.Assert.*
import com.groovy.bean.Person
import org.junit.Test

class Test2 {

	@Test
	public void test() {
		assert(true)
		assert 1 == 1
		def x = 1
		assert x == 1
		def y = 1
		assert x == y
		println 'It is OK.'
	}
	
	@Test
	public void test2() {
		Book gina = new Book('Groovy in action')
		println gina.getTitle()
		println getTitleBackwards(gina)
	}

	String getTitleBackwards(book){
		def title = book.getTitle()
		return title.reverse()
	}
	
	@Test
	public void test3() {
		Person p = new Person()
		Person p2 = new Person(name:'Jack',age:34)
		p.setName('Harry')
		p.setAge(35)
		println "Name is : " + p2.getName()
		println "Name is : ${p.getName()}, age is : $p.age"
	}
	
	@Test
	public void test4() {
		def s1 = 'Harry'
		def s2 = 'it man'
		def s3 =  "I am harry, $s2"
		println s3
		println "I am " + s1 + " and my age is : " + s2
		assert '12345' =~ /\d+/
		assert 'xxxxx' == '12345'.replaceAll(/\d/, 'x')
		
		println "-" * 80
		def x = 1 
		def y = 2
		def z = x + y
		def w = x.plus(y)
		println "z is : $z, w is : $w"
		
		println "-" * 80
		def roman = ['','I','II','III','IV','V','VI','VII']
		println roman[4]
		roman[10] = 'VIII'			//等同于roman.add('VIII')
		println roman.size()
		roman.each{ 
			println "Element is : $it"
		}
		println "-" * 80
		roman.reverseEach{
			println "Element is : $it"
		}
		println "-" * 80
		def http = [
			100 : 'CONTINUE',
			200 : 'OK',
			400 : 'BAD REQUEST'
		]
		println http[200]
		http[500] = 'INTERNAL SERVER ERROR' //等同于http.put(500, 'INTERNAL SERVER ERROR')
		println 'Maps size is : ' + http.size()
		http.each{ k, v ->
			println "Key is $k, value is : $v"			
		}
		def map = [:]
		map['a'] = 200
		map.put('b',300)
		println "map size is : " + map.size()
		map.each{ k, v ->
			println "Key is $k, value is : $v"
		}
	}
	@Test
	public void test5() {
		
		println "-" * 80
		def x = 1..10
		assert x.contains(5) == true
		assert x.contains(15) == false
		assert x.size() == 10
		assert x.from == 1
		assert x.to == 10
		assert x.reverse() == 10..1
		x.each{
			println "Element is : $it"
		}
		println "-" * 80
		
		def a = 10
		switch(a){
			case 0..9:
				println "a"
				break
			case 10..19:
				println "b"
				break
			default:
				println 'c'
				break;
		}
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
}