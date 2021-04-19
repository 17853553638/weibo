package com_fanghao_weibo_dao.impl;

import java.util.List;
import java.util.Map;


import com_fanghao_wb_UserBean.UserBean;
import com_fanghao_weibo_DBUtil.DBUtil;

public class UserDaoimpl {
	// ��ѯ���ݿ�
	/*
	 * ��ѯ�û��Ƿ����
	 */
	DBUtil db=new DBUtil();
				public UserBean chkLogin(UserBean ubean) {// ҳ���ȡ���û���������
						String sql="select * from user where username=? and password=?";
						//?��ռλ��  obj�������� ����˳�������ռλ������һ��
						Object []obj= {ubean.getUsername(),ubean.getPassword()};
						
					
						List<Map<String, String>>  lists =db.query(sql, obj);//��ѯ�������û�
						if(lists.size()!=0) {
						for(Map<String, String> map :lists) {
							UserBean ub =new UserBean();//�����������ڴ洢���ݿ��ѯ����������
							String userid =map.get("userid");//��ȡ���ݱ��� ָ���е�ֵ
							
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
		 * �û�ע�ᣨ������
		 * */
				
				public int addUser(UserBean ub) {
					String sql="insert into user values(null,?,?,?,'img/icon1.png')";
					
					Object [] obj = {ub.getUsername(),ub.getPassword(),ub.getPhone()};
					
					
					
					return db.update(sql, obj);
					
				}
				/*
				 * �û�������
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
				
				   //�������
				

				  public List<Map<String, String>> queryUserbyPwd(String username ) {
					
					String sql = "select password from user where username=?";
					
					Object[] object = {username};
			        
					return db.query(sql, object);
					
				}
				/*
				 * �绰����
				 * */
				public List<Map<String, String>> queryUserByphone(String phone){
					String sql="select *from user where phone=?";
					Object [] obj= {phone};
					return db.query(sql, obj);
				}
				
				/*
				 * �޸����루���ݵ绰�޸����룩
				 * */
					 public int updatePwdByphone(String newPwd,String phone) {
						 
						String sql ="update user set password=? where phone=?";
						Object [] obj= { newPwd,phone};
						 
						 return db.update(sql, obj);
						 
						 
					 }
				/*
				 * ��ѯ�û��Ĺ�ע��
				 * */
				public int queryFollowById(int id) {
				  String sql="select count(userid) from follow where followid = ?";
				  Object [] obj = {id};
				  List<Map<String, String>>  lists =db.query(sql, obj);
				  if(lists.size()!=0) {
					  //lists.get(0)��ȡ�������±�Ϊ0��Ԫ��
					  //get("count(userid)")����������ȡ��Ӧ��ֵ
					return  Integer.parseInt(lists.get(0).get("count(userid)"));
					  
				  }
					return 0;
				}	 
			/*
			 * ��ѯ��˿
			 * */		 
				public int queryUserIdById(int id) {
					  String sql="select count(followid) from follow where userid = ?";
					  Object [] obj = {id};
					  List<Map<String, String>>  lists =db.query(sql, obj);
					  if(lists.size()!=0) {
						  //lists.get(0)��ȡ�������±�Ϊ0��Ԫ��
						  //get("count(userid)")����������ȡ��Ӧ��ֵ
						return  Integer.parseInt(lists.get(0).get("count(followid)"));
						  
					  }
						return 0;
					}	 
				/*
				 * ��ѯ�û�΢��������
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
