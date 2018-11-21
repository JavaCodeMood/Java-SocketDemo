/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018年11月20日 下午12:53:09   
 * @version V1.0 
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 */  

package com.lhf.udp.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**   
 * @ClassName:  UDPClient   
 * @Description: 基于UDP的客户端
 * @author: liuhefei
 * @date:   2018年11月20日 下午12:53:09   
 *     
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		//向服务器端发送数据
		//1. 定义服务器的地址，端口号，数据
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "用户名：admin; 密码：123456".getBytes();  //getBytes是为了把字符串转换成字节数组，然后才能装进packet进行传输啊
		//2.创建数据报，包含发送的数据信息
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        //3.创建DatagramSocket对象
		DatagramSocket socket = new DatagramSocket();
		//4.向服务器发送数据报
		socket.send(packet);
		System.out.println("数据报发送成功");
		
		//接收来自服务器的响应信息
		//1、创建数据报，用于接收服务器端响应的数据
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		//2.接收服务器端响应的数据
		socket.receive(packet2);
		//3. 读取来自服务器端的信息
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("我是客户端，服务器说：" + reply);
		//4.关闭资源
		socket.close();
	}

}
