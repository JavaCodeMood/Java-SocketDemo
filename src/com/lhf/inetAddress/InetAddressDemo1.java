package com.lhf.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 
 * @ClassName:  InetAddressDemo1   
 * @Description: InetAddress
 * @author: liuhefei
 * @date:   2018��11��19�� ����12:04:44   
 *
 */
public class InetAddressDemo1 {
	
	public static void main(String[] args) throws UnknownHostException {
		//��ȡ������InetAddressʵ��
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("address: " + address);
		System.out.println("���������" + address.getHostName());
		System.out.println("IP��ַ�� " + address.getHostAddress());
		
		byte[] bytes = address.getAddress();
		System.out.println("��ȡ�ֽ�������ʽ��IP��ַ�� " + Arrays.toString(bytes));
		
		//���ݻ�������ȡInetAddressʵ��
		InetAddress address2 = InetAddress.getByName("DESKTOP-E8OGBUH");
		System.out.println("�������2��" + address2.getHostName());
		System.out.println("IP��ַ2�� " + address2.getHostAddress());
		
		//����������Ip��ַ��ȡInetAddressʵ��
		InetAddress address3 = InetAddress.getByName("192.168.199.1");
		System.out.println("�������3��" + address3.getHostName());
		System.out.println("IP��ַ3�� " + address3.getHostAddress());
	}

}
