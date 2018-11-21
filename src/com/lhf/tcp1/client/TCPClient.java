/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018年11月19日 下午1:32:37   
 * @version V1.0 
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 */  

package com.lhf.tcp1.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**   
 * @ClassName:  TCPClient   
 * @Description:基于TCP实现socket通信
 * @author: liuhefei
 * @date:   2018年11月19日 下午1:32:37   
 *     
 */
public class TCPClient {
	
	public static void main(String[] args) {
		
		try {
			//1.创建客户端Socket，指定服务器地址和端口
			Socket socket = new Socket("localhost", 8888);
			//2.获取输出流，向服务器端发送信息
			OutputStream os = socket.getOutputStream();   //字节输出流
			PrintWriter pw = new PrintWriter(os);  //将输出流转化为打印流
			pw.write("用户名：admin; 密码： 123456");
			pw.flush();  //刷新缓存
			socket.shutdownOutput();
			//3.获取输入流，用于读取服务器的响应信息
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			//循环获取服务器端信息
			while((info = br.readLine()) != null) {
			   System.out.println("我是客户端，服务器端说： " + info);
			}
			
			//4.关闭资源
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
