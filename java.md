# 常见错误

	- Q:从SVN上检出Maven项目报红叉错误，package错误 does not match the expected package "main.java.com.*
	- A:这是由于build path 没有加载到资源文件目录，右键点击项目src目录，点击build path ,Configure Build Path,然后把source里面的目录都remove出去，最后在add  folder勾选src/main下面的java和resources 点击ok就行了。
