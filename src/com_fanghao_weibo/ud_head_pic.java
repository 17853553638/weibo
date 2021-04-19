package com_fanghao_weibo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com_fanghao_LoginBiz.WbBiz;
import com_fanghao_wb_UserBean.*;
public class ud_head_pic extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ud_head_pic() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		DiskFileItemFactory disk=new DiskFileItemFactory();
//创建文件上传处理对象
		ServletFileUpload sfu = new ServletFileUpload(disk);
		Map texthm = new HashMap<>();
		
		
	   
//获取请求数据
		try {
			List<FileItem> fileItems = sfu.parseRequest(request);
		
			for(FileItem f:fileItems)
			  {
			    
					//图片
			    	  //图片上传路径
			    	  String txPath =request.getServletContext().getRealPath("/upload");
			    	  System.out.println(txPath);
			    	  File file =new File(txPath);
			    	  //判断文件是否存在
			    	  if (!file.exists()) {
			    		  file.mkdirs();
						
					}
			    	  String picpath="";
			    	  if (f.getSize()>0) {
			    		  
			    		  String imgname =f.getName();
			    		  System.out.println(f.getName());
			    		  picpath ="upload/"+imgname;
			    		  try {
							f.write(new File(txPath+"/"+imgname));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    	  f.delete();
			    		  
						
					}
			    	  
			    	  
			    	  texthm.put("pic", picpath);
			    
				
			  }
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		UserBean ubean = (UserBean) session.getAttribute("ub");
		WbBiz wb = new WbBiz();
		texthm.put("userid",ubean.getUserid());
		System.out.println(ubean.getUserid());
		if (wb.Update_Headpic(texthm)!=0) {
			System.out.println("修改成功");	
			response.sendRedirect("init.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
