package com.groovy.basic
import org.junit.Test

class Test3 {

	@Test
	public void test() {
		def me = 'Harry'
		def you = "Jack"
		def line = "I am $me , and you are $you" //GString
		println line  
		println '-' * 80
		def date = new Date(0)
		println date
		def out = "Year $date.year \tMonth $date.month Day\n $date.date"
		println out
		def sql = """
			SELECT FROM MyTable
			WHERE Year = $date.year
		"""
		println sql
		println '-' * 80
//		line = "$me - $you"
//		println line == 'Harry - Jack'
//		println line.equals("Harry - Jack")
//		println line instanceof String
//		println line instanceof GString
		println '-' * 80
//		line = 'ABCDEF'
		println line.strings[0] 
		println line.strings[1]
		println line.values[0]
		println line.values[1]
		println line.strings[2]
		println '-' * 80
		def greeting = 'Hello Groovy!'
		println greeting.startsWith('H')
		println greeting.getAt(4)
		println greeting[4]
		println greeting.indexOf('Groovy')
		println greeting.contains("Groovy")
		println greeting[6..<9]
		println greeting.count('o')
		println 'x'.padLeft(3)
		println 'x'.padRight(3, '_')
		println 'x'.center(3,'-')
		greeting = 'Hello'
		greeting <<= ' Groovy'
		println greeting instanceof StringBuffer
		greeting << "!"
		println greeting.toString()
		println greeting[1..4]
	}
	@Test
	public void test2(){
		def store = ''
		10.times{
			store += 'x'
		}
		println store
		store = ''
		1.upto(5){
			store += it
		}
		println store
		store = ''
		5.downto(1){
			store += it
		}
		println store
		store = ''
		0.step(0.5, 0.1 ){ number ->
			store += number + ' '
		}
		println store
	}
}