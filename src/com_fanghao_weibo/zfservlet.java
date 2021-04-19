package com_fanghao_weibo;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com_fanghao_LoginBiz.WbBiz;
import com_fanghao_wb_UserBean.UserBean;

public class zfservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public zfservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		UserBean ubean2 = (UserBean) session.getAttribute("ub");
		WbBiz biz =new WbBiz();
		
		
		int id = ubean2.getUserid();
		String wbid = request.getParameter("wbid");
		
		int result =biz.zf(wbid,id);
		if (result!=0) {
			System.out.println("³É¹¦");
			
			
		}else {
			System.out.println("Ê§°Ü");
		}
		
		
		System.out.println(wbid);
	    
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
