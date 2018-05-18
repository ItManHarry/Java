package com.groovy.basic
import static org.junit.Assert.*
import org.junit.Test

class Test5 {

	@Test
	public void test() {
		def m = [:]
		println "Map size is : " + m.size()
		println "-" * 80
		def map = [100:"CONTINUE",
				200:"OK",
				400:"BAD REQUEST"
			]
		println "Map size is : " + map.size()
		println "-" * 80
		println "key 200 , value : " + map[200]
		println "key 200 , value : " + map.get(200)
		map.put(500, "INTERNAL SERVER ERROR")
		println "Map size is : " + map.size()
		println "key 500 , value : " + map[500]
		println "key 600 , value : " + map[600]
		println "key 600 , value : " + map.get(600, "DO NOT KNOW")
		map.each{ k,v ->
			println "Key is : $k, value is : $v"
		}
		println "Map size is : " + map.size()
		println "-" * 80
	}

	@Test
	public void test2() {
		println "-" * 80
		def map = [a:1,b:2,c:3]
		println map instanceof HashMap
		println "map size is : " + map.size()
		println "key a : " + map.get("a")
		println "key a -----: " + map.a
		def tm = new TreeMap()
		tm.putAll(map)
		println tm
		assert ['a':1] == [a:1]
		map.clear()
		println map.size()
		println map
		println "-" * 80
	}
	@Test
	public void test3() {
		println "-" * 80
		def myMap = [a:1,b:2,c:3]
		def other = [b:2,c:3,a:1]
		println "myMap equals other : " + (myMap == other)
		println "myMap is other : " + myMap.is(other)
		println "myMap is empty : " + myMap.isEmpty()
		def em = [:]
		println "em is empty : " + em.isEmpty()
		println "Contains key a : " + myMap.containsKey("a")
		println "Contains key e : " + myMap.containsKey("e")
		println "Contains value 2 : " + myMap.containsValue(2)
		println "Contains value 4 : " + myMap.containsValue(4)
		myMap.each{ k,v ->
			println "Key is : $k, value is : $v"
		}
		println "-" * 80
		myMap.keySet().each{
			println "Key is : $it"
		}
		println "-" * 80
		myMap.values().each{
			println "Value is : $it" 
		}
		myMap.each{
			println "Key is : ${it.key}, value is : ${it.value}"
		}
		println "-" * 80
		println myMap.any{
			it.value > 5
		}
		println myMap.every{
			it.key < 'c'
		}
		def nm = myMap.findAll{
			it.value < 3
		}
		def e = myMap.find{
			it.key == 'a'
		}
		println "Element is : "+e.key +":"+e.value
		nm.each{
			println it.key + " : " + it.value
		}
		println "-" * 80
	}
	
	@Test
	public void test4(){
		def words = """
			I am Cheng Guoqian from china
			I am 32 years old now, now I
			am working at doosan 
		""";
		def m = [:];
		words.each { w ->
			if(w.trim() != "")
				m[w] = m.get(w, 0) +1;
		}
		m.each{k, v ->
			println "Key:\t" + k + "\tValue:\t" + v;
		}
	}
}
