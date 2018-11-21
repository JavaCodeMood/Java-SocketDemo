package com.lhf.socket.entity;

import java.io.Serializable;
import java.util.Arrays;

/**   
 * @ClassName:  File   
 * @Description:TODO
 * @author: liuhefei
 * @date:   2018年11月21日 上午11:25:01   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */
public class File implements Serializable{

	private static final long serialVersionUID = -3743565621535824831L;
	
	private int fid;   //文件编号
	private String fname;  //文件名
	private byte[] fcontent;  //文件内容
	

	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public byte[] getFcontent() {
		return fcontent;
	}
	public void setFocntent(byte[] fcontent) {
		this.fcontent = fcontent;
	}
	public File(int fid, String fname, byte[] focntent) {
		this.fid = fid;
		this.fname = fname;
		this.fcontent = focntent;
	}
	public File(String fname,byte[] focntent){
		this.fname=fname;
		this.fcontent=focntent;
	}
	

}
