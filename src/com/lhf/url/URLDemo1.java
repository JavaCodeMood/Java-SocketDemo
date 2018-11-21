package com.lhf.url;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * 
 * @ClassName:  URLDemo  
 * @Description: URL实例读取网页内容
 * @author: liuhefei
 * @date:   2018年11月19日 下午12:04:44   
 *
 */
public class URLDemo1 {
	
	public static void main(String[] args) {
		//创建一个URL实例
		try {
			URL url = new URL("http://www.baidu.com");
			//通过URL的openStream方法获取URL对象所表示的资源的字节输入流
			InputStream is = url.openStream();
			//将字节输入流转化为字符输入流,并指定编码格式
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//为字符输入流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			//读取数据
			String data = br.readLine();
			while(data != null) {  //循环读取数据
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
