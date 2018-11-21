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
 * @date:   2018��11��21�� ����12:01:11   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class SocketClient {
	 Scanner input = new Scanner(System.in);
	    /**
	     * �ͻ��˵�Socket
	     */
	    private Socket socket = null;

	    public void showMainMenu() {
	        System.out.println("��ӭʹ��socket�ļ��ϴ�");
	        System.out.println("1.��¼\n2.ע��\n3.�˳�");
	        System.out.println("*************");
	        System.out.println("��ѡ��:");
	        int choose = input.nextInt();
	        switch (choose) {
	            case 1:
	                showLogin();
	                break;
	            case 2:
	                showRegister();
	                break;
	            case 3:
	                System.out.println("ллʹ��");
	                break;
	            default:
	                System.out.println("��������");
	                System.exit(0);
	        }
	    }

	    /**
	     * �ϴ��ļ�
	     * 
	     * 
	     * @author liuhefei
	     * 2018��11��21��
	     */
	    public void showUploadFile() {
	        System.out.println("�������ļ��ϴ��ľ���·��(����:e:/1.jpg)");
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
	            // �������ݸ������
	            sendData(transfer);
	            // ��ȡ����˷��صķ���
	            transfer = getData();
	            System.out.println(transfer.getResult());
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            closeAll();
	        }
	    }

	    /**
	     * �û�ע��
	     * 
	     * 
	     * @author liuhefei
	     * 2018��11��21��
	     */
	    private void showRegister() {
	        Users user = new Users();
	        CommendTranser transfer = new CommendTranser();
	        while (true) {
	            System.out.println("�������û���");
	            user.setUsername(input.next());
	            System.out.println("����������");
	            user.setPassword(input.next());
	            System.out.println("���ٴ���������");
	            String repassword = input.next();
	            if (!user.getPassword().equals(repassword)) {
	                System.out.println("�������벻һ��");
	                System.out.println("**************");
	                continue;
	            }
	            transfer.setCmd("register");
	            transfer.setData(user);

	            try {
	                socket = new Socket("127.0.0.1", 8088);
	                // �������ݸ������
	                sendData(transfer);
	                // ��ȡ����˷��صķ���
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
	     * �û���¼
	     * 
	     * 
	     * @author liuhefei
	     * 2018��11��21��
	     */
	    private void showLogin() {
	        Users user = new Users();
	        CommendTranser transfer = new CommendTranser();
	        int count = 0;
	        while (true) {
	            count++;
	            if (count > 3) {
	                System.out.println("���Ѿ�����ʧ����...��������������");
	                System.exit(0);
	            }
	            System.out.println("�������û���");
	            user.setUsername(input.next());
	            System.out.println("����������");
	            user.setPassword(input.next());
	            transfer.setCmd("login");
	            transfer.setData(user);

	            try {
	                socket = new Socket("127.0.0.1", 8088);
	                // �����ݷ��͵���������
	                sendData(transfer);
	                // ��ȡ���������ص�����
	                transfer = getData();
	                System.out.println(transfer.getResult());
	                System.out.println("***************");
	                if (transfer.isFlag()) {
	                    // �����¼�ɹ��������ٵ�¼
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
