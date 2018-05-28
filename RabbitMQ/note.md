# Java Queue Framework - RabbitMQ

## 环境安装就配置 - windows

- 下载安装erlang
	
	原因在于RabbitMQ服务端代码是使用并发式语言erlang编写的，[下载地址:http://www.erlang.org/downloads](http://www.erlang.org/downloads)，双击.exe文件进行安装就好，安装完成之后创建一个名为ERLANG_HOME的环境变量，其值指向erlang的安装目录，同时将%ERLANG_HOME%\bin加入到Path中，最后打开命令行，输入erl，如果出现erlang的版本信息就表示erlang语言环境安装成功；
	
- 下载RabbitMQ

	[下载地址:http://www.rabbitmq.com/](http://www.rabbitmq.com/)，同样双击.exe进行安装就好

- 安装RabbitMQ-Plugins

	这个相当于是一个管理界面，方便我们在浏览器界面查看RabbitMQ各个消息队列以及exchange的工作情况，安装方法是：打开命令行cd进入rabbitmq的sbin目录(我的目录是：E:\software\rabbitmq\rabbitmq_server-3.6.5\sbin)，输入：rabbitmq-plugins enable rabbitmq_management命令，稍等会会发现出现plugins安装成功的提示，默认是安装6个插件，如果你在安装插件的过程中出现了错误，解决方法是：首先在命令行输入：rabbitmq-service stop，接着输入rabbitmq-service remove，再接着输入rabbitmq-service install，接着输入rabbitmq-service start，最后重新输入rabbitmq-plugins enable rabbitmq_management试试
	
- 安装完成

	插件安装完之后，在浏览器输入[http://localhost:15672](http://localhost:15672)进行验证，你会看到下面界面，输入用户名：guest，密码：guest你就可以进入管理界面，当然用户名密码你都可以变的