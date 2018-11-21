/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018年11月19日 下午1:23:04   
 * @version V1.0 
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 */  

package com.lhf.tcp1.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**   
 * @ClassName:  TCPServer   
 * @Description: 基于TCP协议实现的socket通信，采用多线程实现用户登录, 多客户端同时登陆
 * @author: liuhefei
 * @date:   2018年11月19日 下午1:23:04   
 *     
 */
public class TCPServer {
	
	public static void main(String[] args) {
		
		try {
			//1.创建一个服务器端socket,即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//记录客户端的连接数量
			int count = 0;
			//2.调用accept()方法开始监听，等待客户端的连接
			System.out.println("*************服务器即将启动，等待客户端连接**************");
		    //循环监听客户端的连接请求
		    while(true) {
		    	//调用accept()方法开始监听，等待客户端的连接
		    	socket = serverSocket.accept();
		    	//创建一个新的线程
		    	ServerThread serverThread = new ServerThread(socket);
		    	//启动线程
		    	serverThread.start();
		    	count++;
		    	System.out.println("连接服务器的客户端数量：" + count);
		    	InetAddress address = socket.getInetAddress();
		    	System.out.println("当前客户端额IP: " + address.getHostAddress());
		    } 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
