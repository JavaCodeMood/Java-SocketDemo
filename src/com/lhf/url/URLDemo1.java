package com.lhf.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 
 * @ClassName:  URLDemo  
 * @Description: URLʵ����ȡ��ҳ����
 * @author: liuhefei
 * @date:   2018��11��19�� ����12:04:44   
 *
 */
public class URLDemo1 {
	
	public static void main(String[] args) {
		//����һ��URLʵ��
		try {
			URL url = new URL("http://www.baidu.com");
			//ͨ��URL��openStream������ȡURL��������ʾ����Դ���ֽ�������
			InputStream is = url.openStream();
			//���ֽ�������ת��Ϊ�ַ�������,��ָ�������ʽ
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//Ϊ�ַ���������ӻ���
			BufferedReader br = new BufferedReader(isr);
			//��ȡ����
			String data = br.readLine();
			while(data != null) {  //ѭ����ȡ����
				System.out.println(data);
				data = br.readLine();
			}
			br.close();
			isr.close();
			is.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
