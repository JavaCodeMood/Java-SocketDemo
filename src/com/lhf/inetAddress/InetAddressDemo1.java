package com.lhf.inetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 
 * @ClassName:  InetAddressDemo1   
 * @Description: InetAddress
 * @author: liuhefei
 * @date:   2018年11月19日 下午12:04:44   
 *
 */
public class InetAddressDemo1 {
	
	public static void main(String[] args) throws UnknownHostException {
		//获取本机的InetAddress实例
		InetAddress address = InetAddress.getLocalHost();
		System.out.println("address: " + address);
		System.out.println("计算机名：" + address.getHostName());
		System.out.println("IP地址： " + address.getHostAddress());
		
		byte[] bytes = address.getAddress();
		System.out.println("获取字节数组形式的IP地址： " + Arrays.toString(bytes));
		
		//根据机器名获取InetAddress实例
		InetAddress address2 = InetAddress.getByName("DESKTOP-E8OGBUH");
		System.out.println("计算机名2：" + address2.getHostName());
		System.out.println("IP地址2： " + address2.getHostAddress());
		
		//根据主机的Ip地址获取InetAddress实例
		InetAddress address3 = InetAddress.getByName("192.168.199.1");
		System.out.println("计算机名3：" + address3.getHostName());
		System.out.println("IP地址3： " + address3.getHostAddress());
	}

}
