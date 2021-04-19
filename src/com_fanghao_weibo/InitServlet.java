package com_fanghao_weibo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.swing.internal.plaf.metal.resources.metal;

import com_fanghao_LoginBiz.UserBiz;
import com_fanghao_LoginBiz.WbBiz;
import com_fanghao_wb_UserBean.Comment;
import com_fanghao_wb_UserBean.UserBean;
import com_fanghao_wb_UserBean.WbBean;

/**
 * Servlet implementation class InitServlet
 */
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		UserBiz ubz = new UserBiz();// 创建对象
		WbBiz wbz =new WbBiz();
		HttpSession session =req.getSession();
		UserBean ub =(UserBean) session.getAttribute("ub");
		//查询关键字
		    List<Map<String, String>> topic =  wbz.queryTopic();
		//查询关注数
				int fo=ubz.queryFollowById(ub.getUserid());
				//粉丝数
				int fz=ubz.queryUserIdById(ub.getUserid());
				//微博数
				int wbsum=ubz.queryWbById(ub.getUserid());
				//查询所有微博（微博的图片，微博的发布人、头像、微博内容）
				WbBiz wb=new WbBiz();
				List<WbBean> wbs =wb.queryALLWb();
				
				for (WbBean w : wbs) {
					int wbid =w.getWbid();
					//查询每条微博的点赞数
					int dzsum=wb.queryDzById(wbid);		
					w.setDzsum(dzsum);

						//每条微博的评论
					
					//String  content =wb.queryCmById( w.getWbid());		
			    	//w.setPinglun(content);
					
					int pinglun =wb.queryWbsumById(wbid);
					w.setPinglun(pinglun);
					
					//该条微博下所有评论内容
					List<Comment> coms= wb.queryCmById(wbid);
					
					w.setComs(coms);
					
				}
				
				
				
			
				

				req.setAttribute("fo", fo);
				req.setAttribute("fz", fz);
				req.setAttribute("wbsum", wbsum);
				req.setAttribute("wbs", wbs);
			    req.setAttribute("topic", topic);
				
				req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
