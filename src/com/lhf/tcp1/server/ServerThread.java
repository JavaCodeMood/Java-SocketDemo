/**   
 *
 * @Description:    TODO 
 * @author: liuhefei   
 * @date:   2018��11��19�� ����1:56:12   
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
 * @Description: ���������̴߳�����
 * @author: liuhefei
 * @date: 2018��11��19�� ����1:56:12
 * 
 */
public class ServerThread extends Thread {

	// �ͱ��߳���ص�Socket
	Socket socket = null;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// �߳�ִ�еĲ�������Ӧ�ͻ��˵�����
	public void run() {
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			// 3.ʵ�����ݽ�������ȡ������,���ڶ�ȡ�ͻ�����Ϣ
			is = socket.getInputStream(); // �ֽ�������
			isr = new InputStreamReader(is); // ���ֽ���ת��Ϊ�ַ���
			br = new BufferedReader(isr); // Ϊ��������ӻ���
			String info = null;
			// ѭ����ȡ�ͻ�����Ϣ
			while ((info = br.readLine()) != null) {
				System.out.println("���Ƿ��������ͻ���˵�� " + info);
			}
			socket.shutdownInput(); // �ر�������
			// 4.��ȡ���������Ӧ�ͻ��˵�����
			os = socket.getOutputStream(); // ��ȡ�����
			pw = new PrintWriter(os); // ��װΪ��ӡ��
			pw.write("��ӭ��");
			pw.flush(); // ����flush()�������������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// �ر���ص���Դ
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
