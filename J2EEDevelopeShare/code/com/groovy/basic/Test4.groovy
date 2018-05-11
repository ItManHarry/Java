package com.groovy.basic

import static org.junit.Assert.*

import org.junit.Test

class Test4 {

	@Test
	public void test() {
		println '-' * 80
		def r = 0..10
		println r.contains(5)
		println r.contains(12)
		println '-' * 80
		def size = r.size()
		println "rang size is : $size"
		println "From : " + r.from + " to : " + r.to
		println r.reverse()
		println '-' * 80
		r.each{
			println it
		}
		println '-' * 80
		def r2 = 10..0
		r2.each{
			println "Element is : $it"
		}
		println '-' * 80
		def sr = 0.0..1.0
		println "sr size is : " + sr.size()
		sr.each{
			println "Element : $it"
		}
		println sr.contains(0.5)
		println '-' * 80
		def age = 32
		switch(age){
			case 1..15:
				println 'Age range in 1'
				break
			case 16..25:
				println 'Age range in 2'
				break
			case 26..35:
				println 'Age range in 3'
				break
			default:
				println 'Age range in other'
				break
		}
		println '-' * 80
		println 4 <=> 3		
		println 2 <=> 3		
		println 3 <=> 3
		def wk1 = new WeekDay('Mon')
		def wk2 = new WeekDay('Fri')
		def str = ''
		for(day in wk1..wk2){
			str += day.toString() + ' '
		}
		println "Work days are : $str"
		println '-' * 80
	}
	@Test
	public void Test2(){
		println '-' * 80
		def list = []
		def l = [1, "Harry", 4.5]
		l.each{
			println it
		}
		println '-' * 80
		def roman = ['','I','II','III','IV','V','VI','VII']
		println "roman size : " + roman.size()
		println roman[3]
		println roman[0..3]
		println roman[2,4,5]
		roman[0..4] = ['A','B','C','D']
		println '-' * 80
		println roman.size()
		roman.each{
			println "After replace : "+it
		}
		println '-' * 80
		roman[8] = 'VIII'
		println roman[100]
		println "roman size : " + roman.size()
		println roman instanceof ArrayList
		roman.add('IX')
		roman << 'XI'
		println "roman size : " + roman.size()
		println '-' * 80
		println roman.isEmpty()
		def l2 = []
		println l2.isEmpty()
		println '-' * 80
		def rl = (0..20).toList()
		println rl.size()
		rl.each{
			println it
		}
		println '-' * 80
		def ll = new LinkedList(rl)
		println ll
		def al = new ArrayList(rl)
		println al
		println '-' * 80
		def fl = [1,[2,3],[4,5]].flatten()
		println fl
		def il = [1,2,3].intersect([6,7,5])
		println il
		def b =  [3,4,5].disjoint([1,2,3])
		println ([3,4,5].disjoint([1,2,3]))
		println roman
		println ([1,2,3].pop())
		def list2 = ['A','B','C']
		def e = list2.pop()
		list2.push('D')
		list2.push('E')
		list2.push('F')
		list2.add('G')
		list2 << 'H'
		println list2
		list2.reverse().each{
			println "After reverse : $it"
		}
		list2 << 'Z'
		list2 << 'Y'
		list2 << 'X'
		println list2
		//println list2.sort()
		list2.remove(1)
		list2.remove('X')
		list2.removeAll(['Y','Z'])
		println list2
		println '-' * 80
		def ns = [1,2,3,4,5,6,7,8]
		def nns = ns.collect{
			it * 2
		}
		println nns
		def nnns = ns.findAll{
			it % 2 == 0
		}
		println nnns
		println '-' * 80
		def nms = [1,2,3,3,2,4,5,6,1,null]
		println '3 .... '+nms.count(3)
		println "max ..." + nms.max()
		println "min ..." + nms.min()
		def two = nms.find{
			it % 2 == 0
		}
		def rlt = nms.every{
			it % 2 == 0
		}
		println 'every...'+rlt
		 rlt = nms.any{
			it % 2 == 0
		}
		println 'any...'+rlt
		println two
		println nms
		//def cnms = new HashSet(nms).toList()
		def cnms = nms.unique()
		println cnms
//		def ncms = nms.findAll{
//			it != null
//		}
		def ncms = nms.grep{it}
		println ncms
		println '-' * 80
		def lll = [1,2,3,4]
		def result = lll.inject(100){ sum, num ->
			sum += num	
		}
		println result
		lll.each{
			println it
		}
		lll.reverseEach{
			println it
		}
		println '-' * 80
	}
}
