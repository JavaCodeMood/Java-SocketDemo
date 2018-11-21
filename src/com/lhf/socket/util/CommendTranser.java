package com.lhf.socket.util;

import java.io.Serializable;

/**
 * @ClassName: CommendTranser
 * @Description:TODO
 * @author: liuhefei
 * @date: 2018年11月21日 上午11:59:50
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 * 
 */

public class CommendTranser implements Serializable {

	private String cmd;// 当前操作的命令
	private Object data;// 发送的数据
	private boolean flag;// 操作是否成功
	private String result;// 返回的结果

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}