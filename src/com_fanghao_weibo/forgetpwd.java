package com_fanghao_weibo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_fanghao_LoginBiz.UserBiz;
import com_fanghao_wb_UserBean.UserBean;
import jdk.net.NetworkPermission;

public class forgetpwd extends HttpServlet {

			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				
				String password=req.getParameter("password");
				String password1=req.getParameter("password1");
				String phone=req.getParameter("phone");
				if(!password.equals(password1)) {
					req.setAttribute("msg2", "注册失败，俩次密码不一致");
					req.getRequestDispatcher("forgetpwd.jsp").forward(req, resp);
					return;
				}
				
				
				UserBiz ubz=new UserBiz();
				int result=ubz.forgetPwdByphone(password, phone);
				if(result==1) {
					
					req.setAttribute("msg", "修改成功");
					req.getRequestDispatcher("index.jsp").forward(req, resp);
				}else {
					
					req.setAttribute("msg2", "手机号不存在，请重新输入！");
					req.getRequestDispatcher("forgetpwd.jsp").forward(req, resp);
				}
			
			}
			
			@Override
			protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(req, resp);
			}
	
	
	
}
