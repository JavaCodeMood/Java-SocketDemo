package com.lhf.socket.socket;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import com.lhf.socket.entity.File;
import com.lhf.socket.entity.Users;
import com.lhf.socket.util.CommendTranser;

/**   
 * @ClassName:  SocketClient   
 * @Description:TODO
 * @author: liuhefei
 * @date:   2018年11月21日 下午12:01:11   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class SocketClient {
	 Scanner input = new Scanner(System.in);
	    /**
	     * 客户端的Socket
	     */
	    private Socket socket = null;

	    public void showMainMenu() {
	        System.out.println("欢迎使用socket文件上传");
	        System.out.println("1.登录\n2.注册\n3.退出");
	        System.out.println("*************");
	        System.out.println("请选择:");
	        int choose = input.nextInt();
	        switch (choose) {
	            case 1:
	                showLogin();
	                break;
	            case 2:
	                showRegister();
	                break;
	            case 3:
	                System.out.println("谢谢使用");
	                break;
	            default:
	                System.out.println("输入有误");
	                System.exit(0);
	        }
	    }

	    /**
	     * 上传文件
	     * 
	     * 
	     * @author liuhefei
	     * 2018年11月21日
	     */
	    public void showUploadFile() {
	        System.out.println("请输入文件上传的绝对路径(例如:e:/1.jpg)");
	        String path = input.next();
	        File file = null;
	        FileInputStream fis = null;
	        BufferedInputStream bis = null;
	        String fname = path.substring(path.lastIndexOf("/") + 1);

	        try {
	            fis = new FileInputStream(path);
	            byte[] fcontent = new byte[fis.available()];
	            bis = new BufferedInputStream(fis);
	            bis.read(fcontent);
	            file = new File(fname, fcontent);

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                bis.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        CommendTranser transfer = new CommendTranser();
	        transfer.setCmd("uploadFile");
	        transfer.setData(file);

	        try {
	            socket = new Socket("127.0.0.1", 8088);
	            // 发送数据给服务端
	            sendData(transfer);
	            // 获取服务端发回的反馈
	            transfer = getData();
	            System.out.println(transfer.getResult());
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            closeAll();
	        }
	    }

	    /**
	     * 用户注册
	     * 
	     * 
	     * @author liuhefei
	     * 2018年11月21日
	     */
	    private void showRegister() {
	        Users user = new Users();
	        CommendTranser transfer = new CommendTranser();
	        while (true) {
	            System.out.println("请输入用户名");
	            user.setUsername(input.next());
	            System.out.println("请输入密码");
	            user.setPassword(input.next());
	            System.out.println("请再次输入密码");
	            String repassword = input.next();
	            if (!user.getPassword().equals(repassword)) {
	                System.out.println("两次密码不一致");
	                System.out.println("**************");
	                continue;
	            }
	            transfer.setCmd("register");
	            transfer.setData(user);

	            try {
	                socket = new Socket("127.0.0.1", 8088);
	                // 发送数据给服务端
	                sendData(transfer);
	                // 获取服务端发回的反馈
	                transfer = getData();
	                System.out.println(transfer.getResult());
	                System.out.println("***************");
	                if (transfer.isFlag()) {
	                    break;
	                }

	            } catch (IOException e) {
	                e.printStackTrace();
	            } finally {
	                closeAll();
	            }
	        }
	        showLogin();
	    }
	    
	    /**
	     * 用户登录
	     * 
	     * 
	     * @author liuhefei
	     * 2018年11月21日
	     */
	    private void showLogin() {
	        Users user = new Users();
	        CommendTranser transfer = new CommendTranser();
	        int count = 0;
	        while (true) {
	            count++;
	            if (count > 3) {
	                System.out.println("您已经三次失败了...请重新启动尝试");
	                System.exit(0);
	            }
	            System.out.println("请输入用户名");
	            user.setUsername(input.next());
	            System.out.println("请输入密码");
	            user.setPassword(input.next());
	            transfer.setCmd("login");
	            transfer.setData(user);

	            try {
	                socket = new Socket("127.0.0.1", 8088);
	                // 将数据发送到服务器端
	                sendData(transfer);
	                // 获取服务器返回的数据
	                transfer = getData();
	                System.out.println(transfer.getResult());
	                System.out.println("***************");
	                if (transfer.isFlag()) {
	                    // 如果登录成功，则不用再登录
	                    break;
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            } finally {
	                closeAll();
	            }
	        }
	        showUploadFile();
	    }

	    private void sendData(CommendTranser transfer) {
	        ObjectOutputStream oos = null;
	        try {
	            oos = new ObjectOutputStream(socket.getOutputStream());
	            oos.writeObject(transfer);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private void closeAll() {
	        try {
	            socket.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }


	    public CommendTranser getData() {
	        ObjectInputStream ois = null;
	        CommendTranser transfer = null;
	        try {
	            ois = new ObjectInputStream(socket.getInputStream());
	            transfer = (CommendTranser) ois.readObject();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	        return transfer;
	    }
}
