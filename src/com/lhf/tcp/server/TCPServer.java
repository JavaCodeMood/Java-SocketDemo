/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018年11月19日 下午1:23:04   
 * @version V1.0 
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 */  

package com.lhf.tcp.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**   
 * @ClassName:  TCPServer   
 * @Description: 基于TCP协议实现的socket通信，实现用户登录
 * @author: liuhefei
 * @date:   2018年11月19日 下午1:23:04   
 *     
 */
public class TCPServer {
	
	public static void main(String[] args) {
		
		try {
			//1.创建一个服务器端socket,即ServerSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.调用accept()方法开始监听，等待客户端的连接
			System.out.println("*************服务器即将启动，等待客户端连接**************");
		    Socket socket = serverSocket.accept();
		    //3.实现数据交互，获取输入流,用于读取客户端信息
		    InputStream is = socket.getInputStream();  //字节输入流
		    InputStreamReader isr = new InputStreamReader(is); //将字节流转化为字符流
		    BufferedReader br = new BufferedReader(isr);  //为输入流添加缓冲
		    String info = null;
		    //循环读取客户端信息
		    while((info = br.readLine()) != null) {
		    	System.out.println("我是服务器，客户端说： " + info);
		    }
		    socket.shutdownInput();  //关闭输入流
		    //4.获取输出流，响应客户端的请求
		    OutputStream os = socket.getOutputStream();  //获取输出流
		    PrintWriter pw = new PrintWriter(os);  //包装为打印流
		    pw.write("欢迎你");
		    pw.flush();    //调用flush()方法将缓冲输出
		    //5.关闭相关的资源
		    pw.close();
		    os.close();
		    br.close();
		    isr.close();
		    is.close();
		    socket.close();
		    serverSocket.close();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
