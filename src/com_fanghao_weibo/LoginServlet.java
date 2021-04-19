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
		// ��ȡ���е�����ֵ���û��������롢�Ƿ��ס���룩
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");

		String password = req.getParameter("password");

		String rempwd = req.getParameter("rempwd");

		

		/*
		 * System.out.println(username); System.out.println(password);
		 * System.out.println(rempwd);
		 */
       // ��ѯ���ݿ�
		UserBean ubean = new UserBean();
		ubean.setUsername(username);
		ubean.setPassword(password);
		
		// ����д��û� ��½�ɹ�
		UserBiz ubz = new UserBiz();// ��������
		UserBean ub = ubz.chkLogin(ubean);// ���ø����е�ʵ������
   if(ub!=null) {
		System.out.println("��¼�ɹ�");
		// �ж�rempwd=1 ��ס����
		if("1".equals(rempwd)) {
			
			String str=URLEncoder.encode(username,"UTF-8");     
			// ���û��������뱣��cookie
			Cookie c1=new Cookie("u", str);
			Cookie c2=new Cookie("p", password);
			
			//����ʱ��
			c1.setMaxAge(60*60*24*7);
			c2.setMaxAge(60*60*24*7);
			//�����Ӧ��
			resp.addCookie(c1);
			resp.addCookie(c2);
			
		}
		//��ѯ���û�����΢��
		
		
		//��ѯÿ��΢�����е�����
		
		
		// ��תҳ��
	      //��½�ߵ���Ϣ
		HttpSession session= req.getSession();
		session.setAttribute("ub", ub);
		req.getRequestDispatcher("init.do").forward(req, resp);
		   
   }
   
   else {
	   
	   System.out.println("��¼ʧ��");
	   req.setAttribute("msg", "�û���������������������µ�¼");
	   req.getRequestDispatcher("index.jsp").forward(req, resp);   
   }
   

   
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
