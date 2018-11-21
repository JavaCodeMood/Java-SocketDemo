package com.lhf.socket.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lhf.socket.entity.File;
import com.lhf.socket.util.DBUtils;

/**   
 * @ClassName:  FileService   
 * @Description:ʵ���ļ��ϴ�����
 * @author: liuhefei
 * @date:   2018��11��21�� ����11:37:10   
 * @Copyright: 2018 https://www.imooc.com/u/1323320
 *     
 */

public class FileService {
	
	private Connection conn = null;
	private PreparedStatement ptmt = null;
	private ResultSet rs = null;
	
	/**
	 * �����ļ�������
	 * @param file
	 * 
	 * @author liuhefei
	 * 2018��11��21��
	 */
	public void saveFile(File file) {
		String sql = ("insert into tb_file(fname, fcontent) values(?,?)");
		try {
			conn = DBUtils.getConnection();  //��������
			ptmt = conn.prepareStatement(sql);
			ptmt.setString(1, file.getFname());
			ptmt.setBytes(2, file.getFcontent());
			ptmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.closeAll(conn, ptmt, rs);  //�ر���Դ
		}
	}
	

}
