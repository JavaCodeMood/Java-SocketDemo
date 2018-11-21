package com.lhf.socket.entity;

import java.io.Serializable;

/**   
 * @ClassName:  User   
 * @Description:TODO
 * @author: liuhefei
 * @date:   2018年11月21日 上午11:25:09
 * @Copyright: ${year} https://www.imooc.com/u/1323320   
 *     
 */
public class Users implements Serializable{

	private static final long serialVersionUID = 2184245718543683240L;
	
	private int id;
	private String username;
	private String password;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Users(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	public Users(){
		
	}

}

