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

# The simple Groovy datatypes

## Working with strings

```
	me = 'Tarzan'
	you = 'Jane'
	line = "me $me - you $you"
	assert line == 'me Tarzan - you Jane'
	date = new Date(0)
	out = "Year $date.year Month $date.month Day $date.date"
	assert out == 'Year 70 Month 0 Day 1'
	out = "Date is ${date.toGMTString()} !"
	assert out == 'Date is 1 Jan 1970 00:00:00 GMT !'
	
	sql = """
	SELECT FROM MyTable
	WHERE Year = $date.year
	"""
	assert sql == """
	SELECT FROM MyTable
	WHERE Year = 70
	"""
	out = "my 0.02\$"
	assert out == 'my 0.02$'
	
	me = 'Tarzan'
	you = 'Jane'
	line = "me $me - you $you"
	assert line == 'me Tarzan - you Jane'
	assert line instanceof GString
	assert line.strings[0] == 'me '
	assert line.strings[1] == ' - you '
	assert line.values[0] == 'Tarzan'
	assert line.values[1] == 'Jane'
	
	greeting = 'Hello Groovy!'
	assert greeting.startsWith('Hello')
	assert greeting.getAt(0) == 'H'
	assert greeting[0] == 'H'
	assert greeting.indexOf('Groovy') >= 0
	assert greeting.contains('Groovy')
	assert greeting[6..11] == 'Groovy'
	assert 'Hi' + greeting - 'Hello' == 'Hi Groovy!'
	assert greeting.count('o') == 3
	assert 'x'.padLeft(3) == ' x'
	assert 'x'.padRight(3,'_') == 'x__'
	assert 'x'.center(3) == ' x '
	assert 'x' * 3 == 'xxx'
	
	greeting = 'Hello'
	greeting <<= ' Groovy'
	assert greeting instanceof java.lang.StringBuffer
	greeting << '!'
	assert greeting.toString() == 'Hello Groovy!'
	greeting[1..4] = 'i'
	assert greeting.toString() == 'Hi Groovy!'
```

## Working with regular expressions

| Symbol | Meaning |
| --- | --- |
| . | Any character| 
| ^ | Start of line (or start of document, when in single-line mode)| 
| $ | End of line (or end of document, when in single-line mode)| 
| \d | Digit character| 
| \D | Any character except digits| 
| \s | Whitespace character| 
| \S | Any character except whitespace| 
| \w | Word character| 
| \W | Any character except word characters| 
| \b | Word boundary| 
| () | Grouping| 
| (x|y) | x or y, as in (Groovy|Java|Ruby)| 
| \1 | Backmatch to group one: for example, find doubled characters with (.)\1| 
| x* | Zero or more occurrences of x| 
| x+ | One or more occurrences of x| 
| x? | Zero or one occurrence of x| 
| x{m,n} | At least m and at most n occurrences of x| 
| x{m} | Exactly m occurrences of x| 
| [a-f] | Character class containing the characters a, b, c, d, e, f| 
| [^a] | Character class containing any character except a| 
| (?is:x) | Switches mode when evaluating x; i turns on ignoreCase, s means single-line mode| 

```
	twister = 'she sells sea shells at the sea shore of seychelles'
	// twister must contain a substring of size 3
	// that starts with s and ends with a
	assert twister =~ /s.a/
	finder = (twister =~ /s.a/)
	assert finder instanceof java.util.regex.Matcher
	// twister must contain only words delimited by single spaces
	assert twister ==~ /(\w+ \w+)*/
	WORD = /\w+/
	matches = (twister ==~ /($WORD $WORD)*/)
	assert matches instanceof java.lang.Boolean
	assert (twister ==~ /s.e/) == false
	wordsByX = twister.replaceAll(WORD, 'x')
	assert wordsByX == 'x x x x x x x x x x'
	words = twister.split(/ /)
	assert words.size() == 10
	assert words[0] == 'she'
	
	myFairStringy = 'The rain in Spain stays mainly in the plain!'
	// words that end with 'ain': \b\w*ain\b
	BOUNDS = /\b/
	rhyme = /$BOUNDS\w*ain$BOUNDS/
	found = ''
	myFairStringy.eachMatch(rhyme) { match ->
	found += match[0] + ' '
	}
	assert found == 'rain Spain plain '
	found = ''
	(myFairStringy =~ rhyme).each { match ->
	found += match + ' '
	}
	assert found == 'rain Spain plain '
	cloze = myFairStringy.replaceAll(rhyme){ it-'ain'+'___' }
	assert cloze == 'The r___ in Sp___ stays mainly in the pl___!'
```

## Working with numbers

- GDK methods on numbers

```
	def store = ''
	10.times{
	store += 'x'
	}
	assert store == 'xxxxxxxxxx'
	store = ''
	1.upto(5) { number ->
	store += number
	}
	assert store == '12345'
	store = ''
	2.downto(-2) { number ->
	store += number + ' '
	}
	assert store == '2 1 0 -1 -2 '
	store = ''
	0.step(0.5, 0.1 ){ number ->
	store += number + ' '
	}
	assert store == '0 0.1 0.2 0.3 0.4 '
```