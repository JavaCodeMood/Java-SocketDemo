package com.lhf.socket.socket;

/**   
 * @ClassName:  SocketStart   
 * @Description: 开启客户端
 * @author: liuhefei
 * @date:   2018年11月21日 下午12:01:39   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class SocketStart {
	
	public static void main(String[] args) {
		SocketClient client = new SocketClient();
		client.showMainMenu();   //调用菜单方法
	}

}
