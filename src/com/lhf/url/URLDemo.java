package com.lhf.url;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * 
 * @ClassName:  URLDemo  
 * @Description: URL实例
 * @author: liuhefei
 * @date:   2018年11月19日 下午12:04:44   
 *
 */
public class URLDemo {
	
	public static void main(String[] args) {
		//创建一个URL实例
		try {
			URL imooc = new URL("http://www.imooc.com");
			//创建一个新的实例, ?后面表示的是参数，#后面表示的是锚点
			URL urlNew = new URL(imooc, "/index.html?username=tom#test");
			System.out.println("协议： " + urlNew.getProtocol());
			System.out.println("主机地址： " + urlNew.getHost());
			//如果未指定端口号，则使用默认的端口号，此时getPort()方法返回值为-1
			System.out.println("端口信息： " + urlNew.getPort());
			System.out.println("文件路径： " + urlNew.getPath());
			System.out.println("文件名：" + urlNew.getFile());
			System.out.println("相对路径： " + urlNew.getRef());
			System.out.println("查询字符串： " + urlNew.getQuery());
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
