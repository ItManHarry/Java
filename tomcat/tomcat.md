## Linux(centos6.5)安装配置Tomcat7

- 上传tomcat安装文件(apache-tomcat-7.0.65.tar.gz)后解压

```
	tar -zxvf apache-tomcat-7.0.65.tar.gz
```

- 指定jdk
	
	1. 目录切换到tomct/bin下；
	
	2. 在setclasspath.sh和catalina.sh文件的开头指定JAVA_HOME和JRE_HOME：假定jdk的目录为/home/java/jdk1.7.0_79   
			
			export JAVA_HOME=/home/java/jdk1.7.0_79    
			export JRE_HOME=/home/java/jdk1.7.0_79/jre

- 设置java内存

	在tomct/bin/catalina.sh中写入 
	
		JAVA_OPTS='-Xms512m -Xmx1024m'
		
- 设置虚拟目录

	修改conf下的server.xml文件
	
在：
```xml
	<Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true"
            xmlValidation="false" xmlNamespaceAware="false">
	</Host>
```
添加Context标签

```xml
	<Host name="localhost"  appBase="webapps"
            unpackWARs="true" autoDeploy="true"
            xmlValidation="false" xmlNamespaceAware="false">
			<Context path="" docBase="换成你的路径" reloadable="true"/>
	</Host>
```


