# The Groovy Basic

## 1.注释 - Commenting

- Scripts首行注释(仅能写首行)

```
	#!/usr/bin/groovy
```

- 单行注释(和Java相同)

```
	// some line comment
```

- 多行注释(和Java相同)

```
	/*
		some multi-
		line comment
	*/
```

## 2.断言 - Assertions

	用以判断程序是否正确。用法：

```
	assert(true)
	assert 1 == 1
	def x = 1
	assert x == 1
	def y = 1
	assert y == 1
```

## 3.Groovy at a glance

- 声明类

```
	class Book{
		private String title
		
		Book(String theTitle){
			title = theTitle
		}
		
		String getTitle(){
			return title
		}
	}
```

- Script脚本使用类

```
	Book gina = new Book('Groovy in Action')
	println gina.getTitle()
	println getTitleBackwards(gina)
	
	String getTitleBackwards(book){
		title = book.getTitle()
		return title.reverse()
	}
```

- GroovyBeans

```
	class Book{
		String title
	}
	
	def book = new Book()
	book.setTitle('Groovy in Action')
	println book.getTitle()
	book.setTitle('Groovy is easy')
	println book.getTitle()
```

- 文本处理

	- GStrings
	
	```
		def nick = 'Gina'
		def book = 'Groovy in Action'
		println "$nick is $book"
	```
	
	- Regular expressions
	
	```
		assert '12345' =~ /\d+/
		assert 'xxxxx' == '12345'.replaceAll(/\d/, 'x')
	```
	
- 数字也是对象

```
	def x = 1
	def y = 2
	assert x + y == 3
	assert x.plus(y) == 3
	assert x instanceof Integer
```

- 使用Lists, maps, ranges

	- Lists
	
	```
		def roman = ['','I','II','III','IV','V','VI','VII']
		println roman[4]
		roman[8] = 'VIII'			//等同于roman.add('VIII')
		println roman.size()
		roman.each{
			println "Element is : $it"
		}
	```
	- Simple Maps
	
	```
		def http = [
			100 : 'CONTINUE',
			200 : 'OK',
			400 : 'BAD REQUEST'
		]
		println http[200]
		http[500] = 'INTERNAL SERVER ERROR' //等同于http.put(500, 'INTERNAL SERVER ERROR')
		println 'Maps size is : ' + http.size()
	```
	
	- Ranges
	
	```
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
	```
	
- Code也是对象:Closures

	```
		[1,2,3].each{ entry ->
			println entry
		}		
	```
	
- Groovy control structures

```
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
```