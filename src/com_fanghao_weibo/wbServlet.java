package com_fanghao_weibo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com_fanghao_LoginBiz.UserBiz;
import com_fanghao_LoginBiz.WbBiz;
import com_fanghao_wb_UserBean.Comment;
import com_fanghao_wb_UserBean.UserBean;
import com_fanghao_wb_UserBean.WbBean;

public class wbServlet extends HttpServlet {
				@Override
				protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// TODO Auto-generated method stub
					UserBiz ubz =new UserBiz();
					HttpSession session= req.getSession();
					UserBean ub=(UserBean) session.getAttribute("ub");
					//查询关注数
					int fo=ubz.queryFollowById(ub.getUserid());
					//粉丝数
					int fz=ubz.queryUserIdById(ub.getUserid());
					//微博数
					int wbsum=ubz.queryWbById(ub.getUserid());
					req.setAttribute("fo", fo);
					req.setAttribute("fz", fz);
					req.setAttribute("wbsum", wbsum);
					
					
					WbBiz wb1=new WbBiz();
		     		List<WbBean> wbs1 =wb1.queryInWb(ub.getUserid());

		     		for (WbBean w : wbs1) {
		     			int wbid =w.getWbid();
		    			//查询每条微博的点赞数
		    			int dzsum=wb1.queryDzById(w.getWbid());		
		    	
		    			w.setDzsum(dzsum);
		    				//每条微博的评论
		    			
		    			//String  content =wb.queryCmById( w.getWbid());		
		    	    	//w.setPinglun(content);
		    			
		    			int pinglun =wb1.queryWbsumById(w.getWbid());
		    			w.setPinglun(pinglun);
		    			
		    			List<Comment> coms= wb1.queryCmById(wbid);
		    			
		    			w.setComs(coms);
		    		}
		     		req.setAttribute("wbs1", wbs1);
		     		req.getRequestDispatcher("weibo.jsp").forward(req, resp); 
				}
				@Override
				protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				doGet(req, resp);
				}
}
