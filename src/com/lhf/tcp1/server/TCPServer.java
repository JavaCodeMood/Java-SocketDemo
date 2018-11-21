/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018��11��19�� ����1:23:04   
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
 * @Description: ����TCPЭ��ʵ�ֵ�socketͨ�ţ����ö��߳�ʵ���û���¼, ��ͻ���ͬʱ��½
 * @author: liuhefei
 * @date:   2018��11��19�� ����1:23:04   
 *     
 */
public class TCPServer {
	
	public static void main(String[] args) {
		
		try {
			//1.����һ����������socket,��ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket = new ServerSocket(8888);
			Socket socket = null;
			//��¼�ͻ��˵���������
			int count = 0;
			//2.����accept()������ʼ�������ȴ��ͻ��˵�����
			System.out.println("*************�����������������ȴ��ͻ�������**************");
		    //ѭ�������ͻ��˵���������
		    while(true) {
		    	//����accept()������ʼ�������ȴ��ͻ��˵�����
		    	socket = serverSocket.accept();
		    	//����һ���µ��߳�
		    	ServerThread serverThread = new ServerThread(socket);
		    	//�����߳�
		    	serverThread.start();
		    	count++;
		    	System.out.println("���ӷ������Ŀͻ���������" + count);
		    	InetAddress address = socket.getInetAddress();
		    	System.out.println("��ǰ�ͻ��˶�IP: " + address.getHostAddress());
		    } 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
