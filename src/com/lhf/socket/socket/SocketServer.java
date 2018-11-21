package com.lhf.socket.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**   
 * @ClassName:  SocketServer   
 * @Description:开启服务端
 * @author: liuhefei
 * @date:   2018年11月21日 下午12:01:28   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class SocketServer {
	
	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(8088);
			Socket socket = null;
			System.out.println("开启sever服务....");
			while(true) {
				socket = serversocket.accept();
				System.out.println("欢迎您....");
				//开启多线程
				SocketThread thread = new SocketThread(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
