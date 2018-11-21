package com.lhf.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @ClassName:  URLDemo  
 * @Description: URLʵ��
 * @author: liuhefei
 * @date:   2018��11��19�� ����12:04:44   
 *
 */
public class URLDemo {
	
	public static void main(String[] args) {
		//����һ��URLʵ��
		try {
			URL imooc = new URL("http://www.imooc.com");
			//����һ���µ�ʵ��, ?�����ʾ���ǲ�����#�����ʾ����ê��
			URL urlNew = new URL(imooc, "/index.html?username=tom#test");
			System.out.println("Э�飺 " + urlNew.getProtocol());
			System.out.println("������ַ�� " + urlNew.getHost());
			//���δָ���˿ںţ���ʹ��Ĭ�ϵĶ˿ںţ���ʱgetPort()��������ֵΪ-1
			System.out.println("�˿���Ϣ�� " + urlNew.getPort());
			System.out.println("�ļ�·���� " + urlNew.getPath());
			System.out.println("�ļ�����" + urlNew.getFile());
			System.out.println("���·���� " + urlNew.getRef());
			System.out.println("��ѯ�ַ����� " + urlNew.getQuery());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
