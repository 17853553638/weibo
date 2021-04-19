package com_fanghao_weibo;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators.FollowingIterator;

import com_fanghao_LoginBiz.WbBiz;
import com_fanghao_wb_UserBean.UserBean;
public class gzservlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
                public gzservlet() {
                	super();
                }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		WbBiz biz =new WbBiz();
		
		String userid = request.getParameter("userid");
		String followid= request.getParameter("followid");
		int result =biz.gz(userid,followid);
		if (result!=0) {
			System.out.println("³É¹¦");
			
			
			
		}else {
			System.out.println("Ê§°Ü");
		}
		
		
		System.out.println(userid);
	    
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
