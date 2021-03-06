# 安装weblogic

- 执行命令(windows cmd下执行 / linux shell中执行)

```
	java -jar [weblogic.jar path]
```

- 参考网址：

	- Windows：https://blog.csdn.net/qq_36868342/article/details/79967606
	
	- Linux：https://blog.csdn.net/cz596738622/article/details/80483812

# 创建域

- windows环境

	- 执行config(D:\weblogic\wlserver_10.3\common\bin\config.exe)

- Linux环境	

	- 执行config(/weblogic/wlserver_10.3/common/bin/config.sh)
	
- 新建服务器(Windows/Linux操作一致)，此过程需要多次重启domain

	- domain创建完成后，登录控制台，点击"环境" -> "服务器" -> "新建"。输入名称"web"，端口号"80"
	
	- 创建完成后，激活更改，此时新建的服务器状态为shutdown
	
	- 在domain目录下新增一文件夹，名字和新建的服务器名称一致(web)
	
	- 免密启动(参考：https://www.cnblogs.com/lcword/p/7833139.html)
	
		在domain新增的目录下新增security文件夹，然后新增boot.properties文件，文件内容为weblogic控制台登录账号和密码，明文即可，
		重启domain后会自动加密。
		
		boot.properties:

```
	password=weblogic2@19
	username=weblogic
```
	- 启动domain
	
		windows启动：首先在domain新增一cmd文件，比如："startWebServer.cmd",文件内容如下：
		
```
	.\bin\startManagedWebLogic.cmd web(和新增的服务器名称一致) http://localhost:7001
```

	分别启动domain目录下的startWeblogic.cmd和startWebServer.cmd即可。
	
	Linux启动：domain下新增一启动脚本：start.sh，内容如下：
	
```
	nohup ./startWebLogic.sh &
	sleep 60
	nohup ./bin/startManagedWebLogic.sh web(和新增的服务器名称一致) http://10.40.128.115(服务器IP地址):7001 > ./web_domain(domain名称即可).log 2>&1 &
```
		
		
- 参考网址：

	- Windows：https://blog.csdn.net/loganwong/article/details/23433729
	
	- Linux：https://jingyan.baidu.com/album/0202781160c2961bcc9ce5e8.html?picindex=1

# 更改域java内存大小(Windows/Linux一样)

- 修改文件：domain目录下bin目录下的setDomainEnv.cmd/sh：

```	
	if "%JAVA_VENDOR%"=="Sun" (
		set WLS_MEM_ARGS_64BIT=-Xms256m -Xmx4096m
		set WLS_MEM_ARGS_32BIT=-Xms256m -Xmx4096m
	) else (
		set WLS_MEM_ARGS_64BIT=-Xms512m -Xmx4096m
		set WLS_MEM_ARGS_32BIT=-Xms512m -Xmx4096m
	)
```
# 修改端口号：

- 在你创建的weblogic的域中找到config\config.xml文件。(如：xxxx\user_projects\domains\base_domain\config\config.xml)
在config.xml文件中找到<server></server>语句块，修改<listen-port></listen-port>即可。

```
	 <server>
		<name>AdminServer</name>
		<ssl>
		  <enabled>false</enabled>
		</ssl>
		<listen-port>7005</listen-port>
		<listen-address>localhost</listen-address>
		<data-source>
		  <rmi-jdbc-security xsi:nil="true"></rmi-jdbc-security>
		</data-source>
	  </server>
```

# weblogic下创建多个domain

```
	1.创建domain(执行/weblogic/wlserver_10.3/common/bin/config.sh)

	2.修改控制台端口号，修改domain/config/config.xml,在server节点下新增监听端口

		<listen-port>7002</listen-port>
		
	3.修改domain/bin/stopWeblogic.sh，将端口号改成7002
	
	4.修改内存大小,domain目录下bin目录下的setDomainEnv.cmd/sh
	
		if "%JAVA_VENDOR%"=="Sun" (
			set WLS_MEM_ARGS_64BIT=-Xms256m -Xmx1024m
			set WLS_MEM_ARGS_32BIT=-Xms256m -Xmx1024m
		) else (
			set WLS_MEM_ARGS_64BIT=-Xms512m -Xmx1024m
			set WLS_MEM_ARGS_32BIT=-Xms512m -Xmx1024m
		)

	5.登录控制台新增服务器-web

	6.domain下新增web文件夹，拷贝security文件夹（为的是免密登录）

	7.执行脚本启动web服务器，注意修改端口号

		./bin/startManagedWebLogic.sh web http://localhost:7002	

	8.上传start/stop脚本
	
		start.sh
		
			nohup ./startWebLogic.sh &
			sleep 60
			nohup ./bin/startManagedWebLogic.sh web http://localhost:7002 > ./doosvn_domain.log 2>&1 &
		
		stop.sh
		
			./bin/stopManagedWebLogic.sh dcs t3://DICLINUX03:7002
			./bin/stopWebLogic.sh
			
	9.更改domain管理后台登录地址，更改完后重启domain生效。
	
		参考网址：https://blog.csdn.net/iwlk/article/details/78844814
```