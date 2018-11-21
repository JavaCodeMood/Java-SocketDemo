/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018年11月20日 下午12:46:47   
 * @version V1.0 
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 */  

package com.lhf.udp.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**   
 * @ClassName:  UDPServer   
 * @Description: 基于UDP协议的socket 服务端，实现用户登录
 * @author: liuhefei
 * @date:   2018年11月20日 下午12:46:47   
 *     
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//服务器接收来自客户端的信息
		//1. 创建服务器端DatagramSocket,指定端口
		DatagramSocket socket = new DatagramSocket(8800);
		//2. 创建数据报，用于接收客户端发送的数据
		byte[] data = new byte[1024];   //创建字节数组，指定接收的数据包大小
		DatagramPacket packet = new DatagramPacket(data, data.length);
		System.out.println("****服务器端已启动，等待客户端连接****");
		//3.接收客户端发送的数据
		socket.receive(packet);  //此方法在接收到数据报之前会一直阻塞
		//4.读取来自客户端的信息
		String info = new String(data, 0, packet.getLength());
		System.out.println("我是服务器，客户端说：" + info);
		
		//服务器端向客户端响应数据
		//1. 定义客户端的地址，端口， 数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "欢迎你".getBytes();
		//2. 创建数据报，包含响应的数据信息
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		//3.响应客户端
		socket.send(packet2);
		//4.关闭资源
		socket.close();
	}

}
