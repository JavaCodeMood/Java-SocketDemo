/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018��11��19�� ����1:23:04   
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
 * @Description: ����TCPЭ��ʵ�ֵ�socketͨ�ţ�ʵ���û���¼
 * @author: liuhefei
 * @date:   2018��11��19�� ����1:23:04   
 *     
 */
public class TCPServer {
	
	public static void main(String[] args) {
		
		try {
			//1.����һ����������socket,��ServerSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket = new ServerSocket(8888);
			//2.����accept()������ʼ�������ȴ��ͻ��˵�����
			System.out.println("*************�����������������ȴ��ͻ�������**************");
		    Socket socket = serverSocket.accept();
		    //3.ʵ�����ݽ�������ȡ������,���ڶ�ȡ�ͻ�����Ϣ
		    InputStream is = socket.getInputStream();  //�ֽ�������
		    InputStreamReader isr = new InputStreamReader(is); //���ֽ���ת��Ϊ�ַ���
		    BufferedReader br = new BufferedReader(isr);  //Ϊ��������ӻ���
		    String info = null;
		    //ѭ����ȡ�ͻ�����Ϣ
		    while((info = br.readLine()) != null) {
		    	System.out.println("���Ƿ��������ͻ���˵�� " + info);
		    }
		    socket.shutdownInput();  //�ر�������
		    //4.��ȡ���������Ӧ�ͻ��˵�����
		    OutputStream os = socket.getOutputStream();  //��ȡ�����
		    PrintWriter pw = new PrintWriter(os);  //��װΪ��ӡ��
		    pw.write("��ӭ��");
		    pw.flush();    //����flush()�������������
		    //5.�ر���ص���Դ
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
