package com_fanghao_weibo;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com_fanghao_LoginBiz.UserBiz;
import com_fanghao_LoginBiz.WbBiz;
import com_fanghao_wb_UserBean.Comment;
import com_fanghao_wb_UserBean.UserBean;
import com_fanghao_wb_UserBean.WbBean;

public class LoginServlet extends HttpServlet {

	private static final String String = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取表单中的三个值（用户名、密码、是否记住密码）
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");

		String password = req.getParameter("password");

		String rempwd = req.getParameter("rempwd");

		

		/*
		 * System.out.println(username); System.out.println(password);
		 * System.out.println(rempwd);
		 */
       // 查询数据库
		UserBean ubean = new UserBean();
		ubean.setUsername(username);
		ubean.setPassword(password);
		
		// 如果有此用户 登陆成功
		UserBiz ubz = new UserBiz();// 创建对象
		UserBean ub = ubz.chkLogin(ubean);// 调用该类中的实例方法
   if(ub!=null) {
		System.out.println("登录成功");
		// 判断rempwd=1 记住密码
		if("1".equals(rempwd)) {
			
			String str=URLEncoder.encode(username,"UTF-8");     
			// 将用户名和密码保存cookie
			Cookie c1=new Cookie("u", str);
			Cookie c2=new Cookie("p", password);
			
			//设置时常
			c1.setMaxAge(60*60*24*7);
			c2.setMaxAge(60*60*24*7);
			//添加响应中
			resp.addCookie(c1);
			resp.addCookie(c2);
			
		}
		//查询该用户所有微博
		
		
		//查询每条微博所有的评论
		
		
		// 跳转页面
	      //登陆者的信息
		HttpSession session= req.getSession();
		session.setAttribute("ub", ub);
		req.getRequestDispatcher("init.do").forward(req, resp);
		   
   }
   
   else {
	   
	   System.out.println("登录失败");
	   req.setAttribute("msg", "用户名或密码输入错误，请重新登录");
	   req.getRequestDispatcher("index.jsp").forward(req, resp);   
   }
   

   
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
