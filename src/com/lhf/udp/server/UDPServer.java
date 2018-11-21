/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018��11��20�� ����12:46:47   
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
 * @Description: ����UDPЭ���socket ����ˣ�ʵ���û���¼
 * @author: liuhefei
 * @date:   2018��11��20�� ����12:46:47   
 *     
 */
public class UDPServer {
	public static void main(String[] args) throws IOException {
		//�������������Կͻ��˵���Ϣ
		//1. ������������DatagramSocket,ָ���˿�
		DatagramSocket socket = new DatagramSocket(8800);
		//2. �������ݱ������ڽ��տͻ��˷��͵�����
		byte[] data = new byte[1024];   //�����ֽ����飬ָ�����յ����ݰ���С
		DatagramPacket packet = new DatagramPacket(data, data.length);
		System.out.println("****�����������������ȴ��ͻ�������****");
		//3.���տͻ��˷��͵�����
		socket.receive(packet);  //�˷����ڽ��յ����ݱ�֮ǰ��һֱ����
		//4.��ȡ���Կͻ��˵���Ϣ
		String info = new String(data, 0, packet.getLength());
		System.out.println("���Ƿ��������ͻ���˵��" + info);
		
		//����������ͻ�����Ӧ����
		//1. ����ͻ��˵ĵ�ַ���˿ڣ� ����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "��ӭ��".getBytes();
		//2. �������ݱ���������Ӧ��������Ϣ
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		//3.��Ӧ�ͻ���
		socket.send(packet2);
		//4.�ر���Դ
		socket.close();
	}

}
