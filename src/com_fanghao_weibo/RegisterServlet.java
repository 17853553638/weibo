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
			req.setAttribute("msg1", "ע��ʧ�ܣ��������벻һ��");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}
		UserBean ub = new UserBean();
		ub.setUsername(username);
		ub.setPassword(password1);
		ub.setPhone(phone);
		
		UserBiz ubz =new UserBiz();
		int result=ubz.register(ub);//������ ע��ʧ�� ����2 �û�����ע��
		
		if(result==0) {//ע��ʧ��
			req.setAttribute("msg1", "ϵͳ�쳣������ϵ����Ա");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			return;
			
		}
		else if(result==2) {
			//�û�����ע��
			req.setAttribute("msg1", "�û�����ע�ᣬ��������д");
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
		else if(result==3) {
			//�绰��ע��
			req.setAttribute("msg1", "�绰��ע�ᣬ��������д");
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		}
		else {
			//ע��ɹ�
			req.setAttribute("msg", "ע��ɹ�");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
			
		}
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
