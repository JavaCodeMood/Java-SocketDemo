package com.lhf.socket.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.lhf.socket.entity.File;
import com.lhf.socket.entity.Users;
import com.lhf.socket.service.FileService;
import com.lhf.socket.service.UsersService;
import com.lhf.socket.util.CommendTranser;

/**   
 * @ClassName:  SocketThread   
 * @Description: socket���߳�
 * @author: liuhefei
 * @date:   2018��11��21�� ����12:01:50   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class SocketThread extends Thread{
	private Socket socket = null;
	private ObjectInputStream ois = null;  //����������
	private ObjectOutputStream oos = null;  //���������
	private UsersService us = new UsersService();  //�û�ҵ�����
	private FileService fs = new FileService();  //�ļ�ҵ�����
	//ͨ�����췽������ʼ��socket
	public SocketThread (Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			ois=new ObjectInputStream(socket.getInputStream());
			oos=new ObjectOutputStream(socket.getOutputStream());
			CommendTranser transer=(CommendTranser)ois.readObject();
			transer=execute(transer);
			oos.writeObject(transer);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public CommendTranser execute(CommendTranser transer){
		String cmd =transer.getCmd();
		if(cmd.equals("login")){
			Users users=(Users)transer.getData();
			boolean flag=us.login(users);
			transer.setFlag(flag);
			if(flag){
				transer.setResult("��¼�ɹ�");
			}else{
				transer.setResult("�û��������벻��ȷ");
			}
		}else if(cmd.equals("register")){
			Users users=(Users)transer.getData();
			us.regist(users);
			boolean flag= us.login(users);
			transer.setFlag(flag);
			if(flag){
				transer.setResult("ע��ɹ�");
			}else{
				transer.setResult("ע��ʧ�ܣ�δ֪ԭ��");

			}
		}else if(cmd.equals("uploadFile")){
			File file=(File)transer.getData();
			fs.saveFile(file);
			transer.setResult(" �ϴ��ɹ�");
		}
		return transer;
	}

}
