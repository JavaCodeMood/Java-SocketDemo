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
 * @Description: socket多线程
 * @author: liuhefei
 * @date:   2018年11月21日 下午12:01:50   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class SocketThread extends Thread{
	private Socket socket = null;
	private ObjectInputStream ois = null;  //对象输入流
	private ObjectOutputStream oos = null;  //对象输出流
	private UsersService us = new UsersService();  //用户业务对象
	private FileService fs = new FileService();  //文件业务对象
	//通过构造方法，初始化socket
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
				transer.setResult("登录成功");
			}else{
				transer.setResult("用户名或密码不正确");
			}
		}else if(cmd.equals("register")){
			Users users=(Users)transer.getData();
			us.regist(users);
			boolean flag= us.login(users);
			transer.setFlag(flag);
			if(flag){
				transer.setResult("注册成功");
			}else{
				transer.setResult("注册失败，未知原因");

			}
		}else if(cmd.equals("uploadFile")){
			File file=(File)transer.getData();
			fs.saveFile(file);
			transer.setResult(" 上传成功");
		}
		return transer;
	}

}
