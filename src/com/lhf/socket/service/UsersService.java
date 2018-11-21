package com.lhf.socket.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lhf.socket.entity.Users;
import com.lhf.socket.util.DBUtils;

/**   
 * @ClassName:  UsersService   
 * @Description:TODO
 * @author: liuhefei
 * @date:   2018��11��21�� ����11:37:26   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class UsersService {
	
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;
	private Connection conn=null;
	
	/**
	 * �û�ע�Ṧ��
	 * @param users
	 * 
	 * @author liuhefei
	 * 2018��11��21��
	 */
	public void regist(Users users) {
		String sql = "insert into tb_user(username, password) values (?,?)";
		try {
			//��������
			conn = DBUtils.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,  users.getUsername());
			ptmt.setString(2,  users.getPassword());
			ptmt.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(conn, ptmt, rs);   //�ر���Դ
		}
	}
	
	/**
	 * �û���¼
	 * @param users
	 * @return
	 * 
	 * @author liuhefei
	 * 2018��11��21��
	 */
	public Boolean login(Users users) {
		String sql = "select username, password from tb_user where username = ? and password = ? ";
		try {
			conn = DBUtils.getConnection();
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1,  users.getUsername());
			ptmt.setString(2,  users.getPassword());
			rs = ptmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(conn, ptmt, rs);
		}
		return false;
	}

}
