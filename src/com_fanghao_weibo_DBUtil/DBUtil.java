package com_fanghao_weibo_DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtil {

	/*
	 * ��ȡ���ݿ�����Connection
	 */
	public Connection getConn() {
//		���ó�ʼֵ
		Connection conn=null;
		try {
//			ע������
			Class.forName("com.mysql.jdbc.Driver");
//			׼���������ݿ����Ϣ
			String url="jdbc:mysql://localhost:3306/ceshi?useUnicode=true&characterEncoding=UTF-8";
			String user="root";
			String password="7696977h";
//			��ȡ����        ��ͼ�������������ݿ� URL ������(������Ի�ȡ��Connection����ô˵���Ѿ������ݿ��������ˡ� )
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	/*
	 * �ر���Դ(PreparedStatement,Connection,ResultSet)
	 * 
	 */
	public void isClose(PreparedStatement ps,Connection conn,ResultSet rs) {
		try {
		if (ps!=null) {
				ps.close();
			} 
		if (rs!=null) {
			 	rs.close();
		}
		if (conn!=null) {
				conn.close();
		}
			}catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
	
	/*
	 * ִ�����ݿ����ɾ�Ĳ���executeUpdate-->����int����   ������0ʧ��   ����1�ɹ���
	 * Object[]�����ʱ������Ҫ��ռλ������ֵ��
	 */
		public int  update(String sql,Object[]obj) {
			
			Connection conn=getConn();
			PreparedStatement ps=null;
			int result=0;
			try {
				ps=conn.prepareStatement(sql);
//				ȥ��
				if (obj!=null) {
				//��ռλ����ֵ
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}					
			}
				result=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				isClose(ps, conn, null);
				
			}
			
			
			return result;
			
		}
		
		
		/*
		 * �����ݿ�Ĳ�ѯ����
		 */
		
		
		public List<Map<String, String>> query(String sql,Object[]obj) {
//			��ȡ����
			Connection conn=getConn();
			
			PreparedStatement ps=null;
			ResultSet rs=null;
//			����һ�����е���������
			List<Map<String, String>> list=new ArrayList<>();
			try {
				
				ps=conn.prepareStatement(sql);
				if (obj!=null) {
					for (int i = 0; i < obj.length; i++) {
						ps.setObject(i+1, obj[i]);
					}
				}
				rs=ps.executeQuery();
				ResultSetMetaData rsmd=rs.getMetaData();//���ֱ�������ǵ���������
//				�����������е����м�¼
				while (rs.next()) {
//					����һ����¼
					Map<String, String> map=new HashMap<String,String>();
//					����ÿһ����¼��������Ϣ             �е�����
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
//						��ȡ����
						String columnName=rsmd.getColumnName(i+1);
						String columnValue=rs.getString(i+1);
						map.put(columnName, columnValue);
					}
					list.add(map);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				isClose(ps, conn, rs);
			}
			return list;
		}
}
