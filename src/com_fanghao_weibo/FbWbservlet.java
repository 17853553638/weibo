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


import com.jredu.wb.util.EmojiUtil;


import com_fanghao_LoginBiz.WbBiz;
import com_fanghao_wb_UserBean.UserBean;



public class FbWbservlet extends HttpServlet {
	
				@Override
				protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					// TODO Auto-generated method stub
					req.setCharacterEncoding("UTF-8");
					resp.setCharacterEncoding("UTF-8");
					//创建工厂类
					DiskFileItemFactory dfif =new DiskFileItemFactory();
					
					//创建文件上传处理对象
					ServletFileUpload sfu =new ServletFileUpload(dfif);
					Map texthm =new HashMap<>();
								try {
									//获取请求中的数据
									List<FileItem> fileItem =sfu.parseRequest(req);
									for(FileItem f : fileItem) {
										
										if(f.isFormField()) {
											//文本
											texthm.put(f.getFieldName(), EmojiUtil.emojiToString(f.getString("UTF-8")));
										}else {
											//图片
											//图片的上传目录
											String txpath =req.getSession().getServletContext().getRealPath("/upload");
											System.out.println(txpath);
											File file = new File(txpath);
											
											if(!file.exists()) {
												//创建
												file.mkdirs();
											}
											
											String picpath ="";
											if(f.getSize()>0) {
												String imgname =f.getName().toString();
												System.out.println(imgname);
												picpath="upload/"+imgname;
												//写入
												f.write(new File(txpath+"/"+imgname));
												f.delete();
												
											}
											texthm.put("pic", picpath);
											System.out.println(picpath);
										}
										
										
									}
									
									sfu.parseRequest(req);
								} catch (FileUploadException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				
								HttpSession session =req.getSession();
								UserBean ub=(UserBean) session.getAttribute("ub");
								texthm.put("userid", ub.getUserid());
								//调用biz
								
								WbBiz wb =new WbBiz();
								int result =wb.fbwb(texthm);
								
								if(result!=0) {
									resp.sendRedirect("init.do");
									
								}
									
				}
				
				@Override
				protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				// TODO Auto-generated method stub
				doGet(req, resp);
				}
}
