package com_fanghao_weibo;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com_fanghao_LoginBiz.WbBiz;
import com_fanghao_wb_UserBean.UserBean;
import com_fanghao_wb_UserBean.Comment;
import com_fanghao_wb_UserBean.WbBean;
public class queryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String topic = request.getParameter("topic");
		
		WbBiz  wbBiz =new WbBiz();
		if(!(topic==null || topic.equals(""))) {
			if (wbBiz.chachong(topic).isEmpty()) {
				int rs = wbBiz.insertTopic(topic);
				System.out.println( "插入成功");
			}else {
				System.out.println("数据库里已存在该数据");
			}
			
		}
		//查询关键字
	    List<Map<String, String>> topic1 =  wbBiz.queryTopic();
	    List<WbBean> list = wbBiz.GetWBByTopic(topic);
		      for(WbBean bbean:list)
		      {
		    	  int wbid = bbean.getWbid();
		    	  int dzsum =wbBiz.queryDzById(wbid);
		    	  int comment_sum =wbBiz.queryWbsumById(wbid);
		    	  List<Comment> com = wbBiz.queryCmById(wbid);
		    	  bbean.setDZ(dzsum);
		    	  bbean.setComment(comment_sum);
		    	  bbean.setComments(com);
		      }
		      request.setAttribute("topic1", topic1);
		      session.setAttribute("topic", list);
		      request.getRequestDispatcher("topic_check.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
