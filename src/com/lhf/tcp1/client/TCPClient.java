/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018��11��19�� ����1:32:37   
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
 * @Description:����TCPʵ��socketͨ��
 * @author: liuhefei
 * @date:   2018��11��19�� ����1:32:37   
 *     
 */
public class TCPClient {
	
	public static void main(String[] args) {
		
		try {
			//1.�����ͻ���Socket��ָ����������ַ�Ͷ˿�
			Socket socket = new Socket("localhost", 8888);
			//2.��ȡ���������������˷�����Ϣ
			OutputStream os = socket.getOutputStream();   //�ֽ������
			PrintWriter pw = new PrintWriter(os);  //�������ת��Ϊ��ӡ��
			pw.write("�û�����admin; ���룺 123456");
			pw.flush();  //ˢ�»���
			socket.shutdownOutput();
			//3.��ȡ�����������ڶ�ȡ����������Ӧ��Ϣ
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info = null;
			//ѭ����ȡ����������Ϣ
			while((info = br.readLine()) != null) {
			   System.out.println("���ǿͻ��ˣ���������˵�� " + info);
			}
			
			//4.�ر���Դ
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
