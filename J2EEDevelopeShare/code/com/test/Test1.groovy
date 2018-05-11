package com.test

import static org.junit.Assert.*

import org.junit.Test

class Test1 {

	@Test
	public void test() {
		def l = [1,2,3]
		println "list size is : " + l.size()
		println l[2]
		l.each{
			println it
		}
		println "-" * 80
		l.reverse().each{
			println it
		}
	}
	@Test
	public void test2(){
		List l1 = new ArrayList();
		l1.add(1);
		l1.add(2);
		System.out.println("List size is : " + l1.size());
		def l2 = []
		l2.add(1);
		l2 << 2
		println "Lise two size is : " + l2.size()
		l2.each{
			println it
		}
		for(int i  =0 ; i < l2.size(); i++){
			System.out.println("List size is : " + l1.get(i));
		}
		def m = [:]
		m.put("A", 1)
		m.put("B", 2)
		m.each{ k, v ->
			println "Key is $k and value is $v"
		}
	}
}
