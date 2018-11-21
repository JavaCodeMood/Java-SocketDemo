/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018年11月19日 下午1:56:12   
 * @version V1.0 
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 */

package com.lhf.tcp1.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ClassName: ServerThread
 * @Description: 服务器端线程处理类
 * @author: liuhefei
 * @date: 2018年11月19日 下午1:56:12
 * 
 */
public class ServerThread extends Thread {

	// 和本线程相关的Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// 线程执行的操作，响应客户端的请求
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			// 3.实现数据交互，获取输入流,用于读取客户端信息
			is = socket.getInputStream(); // 字节输入流
			isr = new InputStreamReader(is); // 将字节流转化为字符流
			br = new BufferedReader(isr); // 为输入流添加缓冲
			String info = null;
			// 循环读取客户端信息
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说： " + info);
			}
			socket.shutdownInput(); // 关闭输入流
			// 4.获取输出流，响应客户端的请求
			os = socket.getOutputStream(); // 获取输出流
			pw = new PrintWriter(os); // 包装为打印流
			pw.write("欢迎你");
			pw.flush(); // 调用flush()方法将缓冲输出
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 关闭相关的资源
				if (pw != null) {
					pw.close();
				}
				if (os != null) {
					os.close();
				}
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (is != null) {
					is.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
