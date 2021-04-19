package com_fanghao_weibo_dao.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.jredu.wb.util.EmojiUtil;


import com_fanghao_wb_UserBean.Comment;
import com_fanghao_wb_UserBean.WbBean;
import com_fanghao_weibo_DBUtil.DBUtil;

/*
 * ΢������ز���
 * 
 * */
public class WbDaoImpl {
     DBUtil db =new DBUtil();
	
				/*
				 * ��ѯ����΢��������Ϣ
				 * */
	  public List<WbBean> queryALLWb() {
		  String sql="select m.*,u.username,u.role from message m left join user u on u.userid=m.userid order by m.wbid desc";
		  //lists �����ѯ����������΢����Ϣ 
		  List<Map<String, String>>  lists=db.query(sql, null);
		  //����list<WbBean>����װ��΢������Ϣ
		  List<WbBean> wbs =new ArrayList<>();
		  for(Map<String, String> m :lists) {
			  WbBean wb= new WbBean();
			  wb.setWbid(Integer.parseInt(m.get("wbid")));//������Ķ�Ӧ���е�����
			  if(m.get("content")==""||m.get("content")==null) {
				  wb.setContent("");
				  
			  }else {
				  
				  try {
					wb.setContent(EmojiUtil.stringToEmoji(m.get("content")));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			 // System.out.println(m.get("content"));
	     	//	  System.out.println(wb.getContent());
			  wb.setTime(m.get("time"));
			  
			  wb.setImg(m.get("img"));
			  
			  wb.setUserid(Integer.parseInt(m.get("userid")));
			  
			  wb.setUsername(m.get("username"));
			  
			  wb.setRole(m.get("role"));
			  
			  wbs.add(wb);
			  
			  
		
			  
		  }
		  return wbs;
	  }
	 
	  public List<WbBean> queryInWb(int userid) {
		  String sql="select m.*,u.username,u.role from message"
		  		+ " m inner join user u on  u.userid=? and u.userid =m.userid order by m.wbid desc";
	
		  Object [] obj = {userid};
		  List<Map<String, String>>  lists=db.query(sql,obj );
		
		  List<WbBean> wbs1 =new ArrayList<>();
		  for(Map<String, String> m :lists) {
			  WbBean wb= new WbBean();
			  wb.setWbid(Integer.parseInt(m.get("wbid")));
			
			  if(m.get("content")==""||m.get("content")==null) {
				  wb.setContent("");
				  
			  }else {
				  
				  try {
					wb.setContent(EmojiUtil.stringToEmoji(m.get("content")));
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  }
			  
			  wb.setTime(m.get("time"));
			  
			  wb.setImg(m.get("img"));
			  
			  wb.setUserid(Integer.parseInt(m.get("userid")));
			  
			  wb.setUsername(m.get("username"));
			  
			  wb.setRole(m.get("role"));
			  
			  wbs1.add(wb);
			  
			  
		
			  
		  }
		  return wbs1;
	  }
	/* public static void main(String[] args) {
		  WbDaoImpl wb =new WbDaoImpl();
		  List<WbBean> lists =wb.queryALLWb();
		  for(WbBean w : lists) {
			  	
			  System.out.println(w.getUsername());
			  System.out.println(w.getContent());
			  System.out.println(w.getRole());
			  System.out.println(w.getImg());
			  System.out.println("------------");
		  }
		  
	  }*/
	  /*
	   * ��ѯ΢���ĵ�����
	   * 
	   * */
	  		public int queryDzById(int wbid) {
	  			String sql ="select count(id) from dz where wbid=? ";
	  			
	  			Object [] obj = {wbid};
	  			List<Map<String, String>>  lists =db.query(sql, obj);
	  			
	  			if(lists.size()==0) {
	  				return 0;
	  				
	  			}

	  			return Integer.parseInt(lists.get(0).get("count(id)"));
	  		}
	  	//�ϴ�ͷ��
	  		public int Update_headpic(Map m) {
	  			String sql = "update user set role=? where userid =? ";
	  			Object[] objects = {m.get("pic"),m.get("userid")};
	  			return db.update(sql, objects);
	  			
	  		}
	  		
	  		/*
	  		 * ��ѯ΢������������
	  		 * */
	  		public int queryWbsumById(int wbid) {
	  			
	  			
	  			String sql ="select count(cid) from comment where wbid = ? ";
	  			Object [] obj = {wbid};
	  			List<Map<String, String>>  lists =db.query(sql, obj);
	  			
	  			if(lists.size()==0) {
	  				return 0;
	  				
	  			}

	  			return Integer.parseInt(lists.get(0).get("count(cid)"));
		
	  		}
	  		/*
	  		 * ��ע
	  		 * */
	  		public int gz(String userid,String followid ) {
	  			String sql ="insert into follow(userid,followid) values(?,?)";
	  			Object[] obj = {userid,followid};
				return db.update(sql, obj);
			}
	  		/*
	  		 * ����
	  		 * */
	  		public int DZ(String wbid) {
	  			String sql = "insert into dz values(null,?) ";
	  			Object[] objects = {wbid};
	  			return db.update(sql, objects);
	  		}
	  		/*
	  		 * �����ݿ�д����
	  		 * */
	  		
	  		public int WriteCmById(Map u) {
	  			String sql="insert into comment values(null,?,?,now(),?)";
	  			Object [] obj = {u.get("wbid"),u.get("comment"),u.get("userid")};
	  			return db.update(sql, obj);
	  		}
	  		// ��ѯ�ؼ���
	  		public  List<Map<String, String>> queryTopic() {
	  			 
	  			String sql = "select topic from mohu ";
	  		    List<Map<String, String>>	result =db.query(sql, null);
	  			
	  			return result;
	  			
	  		}
	  		/**
	  		 * ����
	  		 * @param topic
	  		 * @return
	  		 */
	  		public List<Map<String, String>> Panduanchongfu(String topic) {
	  			
	  			String sql = "select * from mohu where topic = ?";
	  			Object[] params = {topic};
	  			List<Map<String, String>> rs = db.query(sql, params);
	  			
	  			return rs;
	  		}
	  		
	  		
	  		
	  		
	  		//����ؼ���
	  		public int insertTopic(String topic) {
	  			// TODO Auto-generated method stub
	  			Object[] params = {topic};
	  			String sql = "insert into mohu(topic) values(?)";
	  			
	  			int rs = db.update(sql, params);
	  			
	  			
	  			return rs;
	  		}
	  	//ģ����ѯ��
	  		public List<WbBean> queryWBByTopic(String topic) {
	  			// TODO Auto-generated method stub
	  			String obj = "%"+topic+"%";
	  			String sql = "select m.*,u.username,u.role from message m left "
	  					+ "join user u on u.userid=m.userid where Content like ?order by m.wbid desc";
	  			Object[] objects = {obj};
	  			List<Map<String,String>> lists =db.query(sql, objects);
	  			
	  			//����һ��list<WbBean>����װ΢����Ϣ
	  			List<WbBean> wbs = new ArrayList<>();
	  			for(Map<String, String> m:lists) {
	  				
	  				WbBean wb = new WbBean();
	  				wb.setWbid(Integer.parseInt(m.get("wbid")));
	  				
	  				
	  				
	  					if (m.get("Content")==""||m.get("Content")==null) {
	  						
	  						wb.setContent("");
	  						
	  					}
	  					else {
	  						try {
	  							wb.setContent(EmojiUtil.stringToEmoji(m.get("Content")));
	  						} catch (UnsupportedEncodingException e) {
	  							// TODO Auto-generated catch block
	  							e.printStackTrace();
	  						}
	  					}
	  					
	  					
	  				
	  				wb.setImg(m.get("img"));
	  				wb.setTime(m.get("time"));
	  				wb.setRole(m.get("role"));
	  				wb.setUserid(Integer.parseInt(m.get("userid")));
	  				wb.setUsername(m.get("username"));
	  				wb.setContent(m.get("content"));
	  				wbs.add(wb);
	  			}
	  			return wbs;
	  		}
	  		
	  		/*
	 * ��ѯ΢������������
	 * */
	  		public List<Comment> queryCmById(int wbid) {
	  			String sql ="select * from comment where wbid =? ";
	  			Object [] obj = {wbid};
	  			//���۵ļ���
	  			List<Map<String, String>>  lists =db.query(sql, obj);
	  			List<Comment> coms =new ArrayList<>();
	  			for (Map<String, String> m :lists) {
	  				Comment c=new Comment();
	  				c.setId(Integer.parseInt(m.get("cid")));
	  				c.setWbid(Integer.parseInt(m.get("wbid")));
	  				c.setContent(m.get("content"));
	  				c.setTime(m.get("time"));
	  				String username= queryNameByUserId(Integer.parseInt(m.get("userid")));
	  				c.setUsername(username);
	  				coms.add(c);
	  			}
	  			
	  			
	  				return coms;
	  		}
	  		/*
	  		 * �����û���ID��ѯ�û���
	  		 * */
	  		public String queryNameByUserId(int userid) {
	  			
	  			String sql="select username from user where userid =?";
	  			
	  			Object [] obj = {userid};
	  			List<Map<String, String>>  lists =db.query(sql, obj);
	  			if(lists.size()!=0) {
	  				
	  				return lists.get(0).get("username");
	  				
	  			}
	  			return "�޴��û�";
	  		}
	  		/*
	  		 * ΢��ת��
	  		 * */
	  		public int  ZF(String wbid,int id) {
	  			
	  			String userid = Integer.toString(id);
	  			String content ="";
	  			String img = "";
	  			String sql = "select Content,img from message where wbid=?";
	  			Object[] objects = {wbid};
	  			List<Map<String, String>> list = db.query(sql, objects);
	  			for(Map<String, String> map : list) 
	  			{
	  				content = map.get("Content");
	  				img = map.get("img");
	  				
	  			}
	  			
	  			String sql1 ="insert into message values(null,?,now(),?,?)";
	  			Object[] objects2= {content,img,userid};
	  			return db.update(sql1, objects2);
	  			
	  		}
	  		
	  		
	  		//����΢��
	  		public int fbwb(Map m) {
	  			String sql="insert into message values(null,?,now(),?,?)";
	  			Object [] obj = {m.get("fbContent"),m.get("pic"),m.get("userid")};
	  			return db.update(sql, obj);
	  		}
/*	  		public int dzjy(int wbid) {
	  			String sql="select count(id) from dz where wbid=? ";
	  			Object [] obj = {wbid};
	  			List<Map<String, String>>  lists =db.query(sql, obj);
	  			
	  			if(lists.size()==0) {
	  				return Integer.parseInt(lists.get(0).get("count(cid)+1")) ;
	  				
	  			}

	  			return Integer.parseInt(lists.get(0).get("count(cid)-1"));
		
	  		}*/
	  		}


	
	  			
	  		
	  		
	  		

