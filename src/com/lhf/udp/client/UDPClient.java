/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018��11��20�� ����12:53:09   
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
 * @Description: ����UDP�Ŀͻ���
 * @author: liuhefei
 * @date:   2018��11��20�� ����12:53:09   
 *     
 */
public class UDPClient {

	public static void main(String[] args) throws IOException {
		//��������˷�������
		//1. ����������ĵ�ַ���˿ںţ�����
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "�û�����admin; ���룺123456".getBytes();  //getBytes��Ϊ�˰��ַ���ת�����ֽ����飬Ȼ�����װ��packet���д��䰡
		//2.�������ݱ����������͵�������Ϣ
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        //3.����DatagramSocket����
		DatagramSocket socket = new DatagramSocket();
		//4.��������������ݱ�
		socket.send(packet);
		System.out.println("���ݱ����ͳɹ�");
		
		//�������Է���������Ӧ��Ϣ
		//1���������ݱ������ڽ��շ���������Ӧ������
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		//2.���շ���������Ӧ������
		socket.receive(packet2);
		//3. ��ȡ���Է������˵���Ϣ
		String reply = new String(data2, 0, packet2.getLength());
		System.out.println("���ǿͻ��ˣ�������˵��" + reply);
		//4.�ر���Դ
		socket.close();
	}

}
