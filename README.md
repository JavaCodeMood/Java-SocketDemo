# 1.网络基础知识
	例子：两台计算机之间进行通信，需要有一个标识，也就是IP地址
	其次两者之间的语言应该一致，这里的语言指的是协议，只有遵循了相同的协议，
	两者才能正常的通信，另外，每台计算机都有相应的端口号

	TCP/IP是目前世界上应用最广泛的协议，是以TCP和IP为基础的不同层次上多个协议的集合，也称TCP/IP协议族或者TCP/IP协议栈
	TCP:Transmission Control Protocol 传输控制协议
	IP：Internet Protocol 互联网协议

	TCP/IP四层模型
	数据链路层，网络层，传输层，应用层
	七层模型与四层模型的关系以及区别
		1.从发展历程看：七层模型是先有理论支撑再有实践，而四层模型是先有实践然后根据实践在仿照七层模型提出了四层模型。
		2.从实用性看：七层模型是理论模型，而四层模型被广泛运用，成为互联网的标准

	IP地址：		
		为实现网络中不同计算机之间的通信，每台机器必须有一个唯一的标识--IP地址
		常见格式：192.168.25.130
	端口：
		1.用于区分不同的应用程序
		2.端口号范围为0~65535，其中0~1023为系统所保留
		3.IP地址和端口号组成了Socket,Socket是网络上运行程序之间双向通信链路的终结点，是TCP/UDP的基础
		4.http : 80  ftp ： 21 telnet : 23
	Java中的网络支持：
		1.InetAddress:用于标识网络上的硬件资源
		2.URL:统一资源定位符，通过URL可以直接读取或者写入网络中的数据
		3.Sockets:使用TCP协议实现网络通信的Socket相关的类
		4.Datagram:使用UDP协议，将数据保存到数据报中，通过网络进行通信
# 2.InetAddress

# 3.URL
# 4.TCP编程
	TCP协议是面向连接、可靠的、有序的，以字节流的方式发送数据
	基于TCP协议实现网络通信的类
		客户端的Socket类
		服务端的ServerSocket类

	实现步骤：
		1.创建ServerSocket和Socket
		2.打开连接到Socket的输入/输出流
		3.按照协议对Socket进行读/写操作
		4.关闭输入输出流、关闭Socket
	可参照项目里的代码
		
# 5.UDP编程
	UDP协议（用户数据报）是无连接、不可靠的、无序的，进行传输时，首先需要将传输的数据定义为数据报（Datagram），在数据报中指明数据所要到达的Socket(主机地址和端口号),然后再将数据报发送出去、
	基于UCP协议实现通信的类
		DatagramPacket:表示数据报包
		DatagramSocket:进行端到端通信的类
	服务端实现的步骤：
		1.创建DatagramSocket,指定端口号
		2.创建DatagramPacket
		3.接收客户端发送的数据信息
		4.读取数据
	客户端的实现步骤：
		1.定义发送信息
		2.创建DatagramPacket,包含要发送的消息
		3.创建DatagramSocket
		4.发送数据
		
# 问题总结：
	1.多线程的优先级，因为在多线程的情况下，未设置优先级可能会导致运行时速度非常慢，可降低优先级

	2.对于同一个Socket,如果关闭了输出流，则与该输出流关联的socket也会被关闭，所以一般不用关闭流，直接关闭socket即可

	3.在案例中使用的是字符串的传输，然后在实际的过程中是以对象的形式，所以这里要使用到对象的序列化操作，传递对象

	4.socket编程传递文件