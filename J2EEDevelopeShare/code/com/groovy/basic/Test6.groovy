package com.groovy.basic

import static org.junit.Assert.*

import org.junit.Test

import com.groovy.classes.MethodClosure
import com.groovy.classes.MultiMethod

class Test6 {
	def map = [:]
	@Test
	public void test() {
		println '-' * 80
		def log = ''
		(1..10).each{
			log += it
		}
		println "log is : $log"
		println '-' * 80
		def logger = { log += it }
		log = ''
		(1..10).each(logger)
		println "log is : $log"
		println '-' * 80
		MethodClosure mc1 = new MethodClosure(6)
		MethodClosure mc2 = new MethodClosure(5)
		Closure c1 = mc1.&validate
		Closure c2 = mc2.&validate
		def words = ["long string","tom","medium","short","tiny","harry"]
		words.grep(c2).each{
			println "String is : $it"
		}
		println '-' * 80
		def map = ['a':1, 'b':2]
		def doubler = { k, v ->
			map[k] = v * 2;
		}
		map.each(doubler);
		map.each {
			println it.key + "\t:\t" + it.value
		}
		println '-' *80
		def map2 = ['a':10, 'b':20]
		doubler = this.&doubleMethod
//		map2.each({k,v ->
//			map2[k] = v * 2
//		})
		map2.each(doubler)
		map2.each({
			println "New map key is : " + it.key + "\t value is :\t" + it.value
		})
		println '-' * 80
		MultiMethod mm = new MultiMethod()
		Closure mc = mm.&getResult
		println mc("I am Harry.Cheng")
		println mc([1,2,3,4,5,6,7,8,9,0])
		println mc(100, 200)
		println '-' * 80
	}
	@Test
	public void test2(){
		map = ['a':1, 'b':2]
		println "----------------------------------"
		def doubler = this.&doubleMethod
		map.each(doubler)
		map.each{
			println "Key is : " + it.key + "\t value is :\t" + it.value
		}
		println "----------------------------------"
	}
	
	def doubleMethod(entry){
		println "Closure key is : ${entry.key}, value is : ${entry.value}"
		println '*' * 80
		map[entry.key] = entry.value * 2
	}
}
