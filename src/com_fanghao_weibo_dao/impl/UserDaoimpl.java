package com_fanghao_weibo_dao.impl;

import java.util.List;
import java.util.Map;


import com_fanghao_wb_UserBean.UserBean;
import com_fanghao_weibo_DBUtil.DBUtil;

public class UserDaoimpl {
	// 查询数据库
	/*
	 * 查询用户是否存在
	 */
	DBUtil db=new DBUtil();
				public UserBean chkLogin(UserBean ubean) {// 页面获取的用户名和密码
						String sql="select * from user where username=? and password=?";
						//?是占位符  obj参数数组 个数顺序必须与占位符保持一致
						Object []obj= {ubean.getUsername(),ubean.getPassword()};
						
					
						List<Map<String, String>>  lists =db.query(sql, obj);//查询出来的用户
						if(lists.size()!=0) {
						for(Map<String, String> map :lists) {
							UserBean ub =new UserBean();//创建对象用于存储数据库查询出来的数据
							String userid =map.get("userid");//获取数据表中 指定列的值
							
							ub.setUserid(Integer.parseInt(userid));
							ub.setUsername(map.get("username"));
							
							ub.setPassword(map.get("password"));
							
							ub.setPhone(map.get("phone"));
							ub.setRole(map.get("role"));
							return ub;
					     	}
						}
							return null;

	}
				
		/*
		 * 用户注册（新增）
		 * */
				
				public int addUser(UserBean ub) {
					String sql="insert into user values(null,?,?,?,'img/icon1.png')";
					
					Object [] obj = {ub.getUsername(),ub.getPassword(),ub.getPhone()};
					
					
					
					return db.update(sql, obj);
					
				}
				/*
				 * 用户名查重
				 * */
				public  List<Map<String, String>> queryUserByUsername(String username) {
					String sql="select *from user where username=?";
					Object [] obj= {username};
					return db.query(sql, obj);
							
					
				}

				public String queryroleByid(int id) {
					// TODO Auto-generated method stub
					String sql = "select role from user where userid=?";
					String userid = Integer.toString(id);
				    Object [] obj = {userid};
					
					List<Map<String,String>> lists = db.query(sql, obj);
					if (lists.size()!=0) {
						for( Map<String, String> map : lists)
						{
							return map.get("role");
						}
					  
						
					}
					return null;
				}
				
				   //密码查重
				

				  public List<Map<String, String>> queryUserbyPwd(String username ) {
					
					String sql = "select password from user where username=?";
					
					Object[] object = {username};
			        
					return db.query(sql, object);
					
				}
				/*
				 * 电话查重
				 * */
				public List<Map<String, String>> queryUserByphone(String phone){
					String sql="select *from user where phone=?";
					Object [] obj= {phone};
					return db.query(sql, obj);
				}
				
				/*
				 * 修改密码（根据电话修改密码）
				 * */
					 public int updatePwdByphone(String newPwd,String phone) {
						 
						String sql ="update user set password=? where phone=?";
						Object [] obj= { newPwd,phone};
						 
						 return db.update(sql, obj);
						 
						 
					 }
				/*
				 * 查询用户的关注量
				 * */
				public int queryFollowById(int id) {
				  String sql="select count(userid) from follow where followid = ?";
				  Object [] obj = {id};
				  List<Map<String, String>>  lists =db.query(sql, obj);
				  if(lists.size()!=0) {
					  //lists.get(0)获取集合中下标为0的元素
					  //get("count(userid)")根据列名获取对应的值
					return  Integer.parseInt(lists.get(0).get("count(userid)"));
					  
				  }
					return 0;
				}	 
			/*
			 * 查询粉丝
			 * */		 
				public int queryUserIdById(int id) {
					  String sql="select count(followid) from follow where userid = ?";
					  Object [] obj = {id};
					  List<Map<String, String>>  lists =db.query(sql, obj);
					  if(lists.size()!=0) {
						  //lists.get(0)获取集合中下标为0的元素
						  //get("count(userid)")根据列名获取对应的值
						return  Integer.parseInt(lists.get(0).get("count(followid)"));
						  
					  }
						return 0;
					}	 
				/*
				 * 查询用户微博的数量
				 * */
				
				public int queryWbById(int id) {
						
				String sql="select * from message where userid = ?";
				Object [] obj = {id};
				List<Map<String, String>>  lists =db.query(sql, obj);
				if(lists.size()==0) {
					return 0;
				}
				return lists.size();
			
				}
				
}
