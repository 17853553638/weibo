package com_fanghao_LoginBiz;

import java.util.List;
import java.util.Map;

import com_fanghao_wb_UserBean.UserBean;
import com_fanghao_weibo_dao.impl.UserDaoimpl;

public class UserBiz {

	UserDaoimpl  udi = new UserDaoimpl();
	    //判断
					public UserBean chkLogin(UserBean ubean) {//页面获取的用户名和密码
						
					    UserBean ub=	udi.chkLogin(ubean);
						
						return ub;
						
					}
					
					public int register(UserBean ub) {
						//用户名不能重复 (mysql)
						List<Map<String, String>> lists=	udi.queryUserByUsername(ub.getUsername());
						if(!(lists==null||lists.size()==0)) {
							//可以注册
							return 2;
							
						}
						
						//电话不能重复(mysql)
						List<Map<String, String>> listp= udi.queryUserByphone(ub.getPhone());
						if(!(listp==null||listp.size()==0)) {
							//可以注册
							return 3;
							
						}
					
						
						
						//新增
								
						return udi.addUser(ub);
						
						
					}
					public int forgetPwdByphone(String newPwd,String phone ) {
						
						
						return udi.updatePwdByphone(newPwd, phone);
						
						
						
					}
					
					public int queryFollowById(int id) {
						
						return udi.queryFollowById(id);//返回给servlet;
						
					}
					public int queryUserIdById(int id) {
						
						return udi.queryUserIdById(id);
					}
					public int queryWbById(int id) {
						
						return udi.queryWbById(id);
					}
					
}
