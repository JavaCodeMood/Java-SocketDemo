package com.lhf.socket.socket;

import java.net.ServerSocket;
import java.net.Socket;

/**   
 * @ClassName:  SocketServer   
 * @Description:���������
 * @author: liuhefei
 * @date:   2018��11��21�� ����12:01:28   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class SocketServer {
	
	public static void main(String[] args) {
		try {
			ServerSocket serversocket = new ServerSocket(8088);
			Socket socket = null;
			System.out.println("����sever����....");
			while(true) {
				socket = serversocket.accept();
				System.out.println("��ӭ��....");
				//�������߳�
				SocketThread thread = new SocketThread(socket);
				thread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
