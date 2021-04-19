package com_fanghao_weibo;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com_fanghao_LoginBiz.UserBiz;
import com_fanghao_wb_UserBean.UserBean;

public class RegisterServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String password1=req.getParameter("password1");
		String phone=req.getParameter("phone");
		String str=URLEncoder.encode(username,"UTF-8"); 
		if(!password.equals(password1)) {
			req.setAttribute("msg1", "注册失败，俩次密码不一致");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}
		UserBean ub = new UserBean();
		ub.setUsername(username);
		ub.setPassword(password1);
		ub.setPhone(phone);
		
		UserBiz ubz =new UserBiz();
		int result=ubz.register(ub);//返回零 注册失败 返回2 用户名已注册
		
		if(result==0) {//注册失败
			req.setAttribute("msg1", "系统异常，请联系管理员");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			return;
			
		}
		else if(result==2) {
			//用户名已注册
			req.setAttribute("msg1", "用户名已注册，请重新填写");
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
		else if(result==3) {
			//电话已注册
			req.setAttribute("msg1", "电话已注册，请重新填写");
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
		else {
			//注册成功
			req.setAttribute("msg", "注册成功");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
