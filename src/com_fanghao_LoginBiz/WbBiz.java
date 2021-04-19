package com_fanghao_LoginBiz;

import java.util.List;
import java.util.Map;

import com_fanghao_wb_UserBean.Comment;
import com_fanghao_wb_UserBean.WbBean;
import com_fanghao_weibo_dao.impl.WbDaoImpl;

public class WbBiz {
/*
 * 微博的逻辑处理
 * 
 * */
	WbDaoImpl wdi =new WbDaoImpl();
	public  List<WbBean> queryALLWb(){
		
		return wdi.queryALLWb();
	}
	WbDaoImpl wdi1 =new WbDaoImpl();
   public  List<WbBean> queryInWb(int userid){
		
		return wdi1.queryInWb(userid);
	}
   /*
    * 查询微博的点赞数
    * */
	public int queryDzById(int wbid) {
		
		return wb.queryDzById(wbid);
		
	}
	/*
	 * 关注
	 * */
	public int gz(String userid,String followid) {
		return wb.gz(userid,followid);
	}
		
	
	/*
	 * 微博点赞
	 * */
	WbDaoImpl wb =new WbDaoImpl();
      public int DZ(String wbid) {
		
		return wb.DZ(wbid);
		
	}
	/*
	 * 查询微博的数量
	 * */
 public int queryWbsumById(int wbid){
	 
	 return wdi.queryWbsumById(wbid);
 }
	
	
   /*
    * 查询微博的评论
    * */
    public List<Comment> queryCmById(int wbid){
    	 
    	return wdi.queryCmById(wbid);
    	
    
}
    public int fbwb(Map m) {
    	
    	return wdi.fbwb(m);
    	
    }
    /*
     * 微博转发
     * */
    public int zf(String wbid, int id) {
		// TODO Auto-generated method stub
		return wb.ZF(wbid, id);
	}
  //上传头像
  	public int Update_Headpic(Map m)
  	{
  		return wb.Update_headpic(m);
  	}
  /*
   * 模糊查询
   * */
    public List<WbBean> GetWBByTopic(String topic) {
		
		return wb.queryWBByTopic(topic);
		
	}
    /*
     * 关键字插入
     * */
   public int insertTopic(String topic) {
		
		return wb.insertTopic(topic);
		
	}
 /*
  * 关键字查询
  * */
  public  List<Map<String, String>> queryTopic() {
	  
	  return wb.queryTopic();
  }
  
  /*
   * 关键字查重
   */
  public List<Map<String , String>>  chachong(String topic) {
	  
	return wb.Panduanchongfu(topic);
}
    }
