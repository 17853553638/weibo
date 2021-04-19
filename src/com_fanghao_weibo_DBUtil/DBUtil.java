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
	 * 获取数据库链接Connection
	 */
	public Connection getConn() {
//		设置初始值
		Connection conn=null;
		try {
//			注册驱动
			Class.forName("com.mysql.jdbc.Driver");
//			准备链接数据库的信息
			String url="jdbc:mysql://localhost:3306/ceshi?useUnicode=true&characterEncoding=UTF-8";
			String user="root";
			String password="7696977h";
//			获取链接        试图建立到给定数据库 URL 的连接(如果可以获取到Connection，那么说明已经与数据库连接上了。 )
			conn=DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	/*
	 * 关闭资源(PreparedStatement,Connection,ResultSet)
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
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	
	/*
	 * 执行数据库的增删改操作executeUpdate-->返回int类型   （返回0失败   返回1成功）
	 * Object[]代表的时参数（要给占位符赋的值）
	 */
		public int  update(String sql,Object[]obj) {
			
			Connection conn=getConn();
			PreparedStatement ps=null;
			int result=0;
			try {
				ps=conn.prepareStatement(sql);
//				去空
				if (obj!=null) {
				//给占位符赋值
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}					
			}
				result=ps.executeUpdate();
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally{
				isClose(ps, conn, null);
				
			}
			
			
			return result;
			
		}
		
		
		/*
		 * 对数据库的查询方法
		 */
		
		
		public List<Map<String, String>> query(String sql,Object[]obj) {
//			获取链接
			Connection conn=getConn();
			
			PreparedStatement ps=null;
			ResultSet rs=null;
//			代表一个表中的所有数据
			List<Map<String, String>> list=new ArrayList<>();
			try {
				
				ps=conn.prepareStatement(sql);
				if (obj!=null) {
					for (int i = 0; i < obj.length; i++) {
						ps.setObject(i+1, obj[i]);
					}
				}
				rs=ps.executeQuery();
				ResultSetMetaData rsmd=rs.getMetaData();//出现报错可能是导包导错了
//				遍历整个表中的所有记录
				while (rs.next()) {
//					代表一条记录
					Map<String, String> map=new HashMap<String,String>();
//					遍历每一条记录的所有信息             列的总数
					for (int i = 0; i < rsmd.getColumnCount(); i++) {
//						获取列名
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
