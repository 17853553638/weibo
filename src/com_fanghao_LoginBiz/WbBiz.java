package com_fanghao_LoginBiz;

import java.util.List;
import java.util.Map;

import com_fanghao_wb_UserBean.Comment;
import com_fanghao_wb_UserBean.WbBean;
import com_fanghao_weibo_dao.impl.WbDaoImpl;

public class WbBiz {
/*
 * ΢�����߼�����
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
    * ��ѯ΢���ĵ�����
    * */
	public int queryDzById(int wbid) {
		
		return wb.queryDzById(wbid);
		
	}
	/*
	 * ��ע
	 * */
	public int gz(String userid,String followid) {
		return wb.gz(userid,followid);
	}
		
	
	/*
	 * ΢������
	 * */
	WbDaoImpl wb =new WbDaoImpl();
      public int DZ(String wbid) {
		
		return wb.DZ(wbid);
		
	}
	/*
	 * ��ѯ΢��������
	 * */
 public int queryWbsumById(int wbid){
	 
	 return wdi.queryWbsumById(wbid);
 }
	
	
   /*
    * ��ѯ΢��������
    * */
    public List<Comment> queryCmById(int wbid){
    	 
    	return wdi.queryCmById(wbid);
    	
    
}
    public int fbwb(Map m) {
    	
    	return wdi.fbwb(m);
    	
    }
    /*
     * ΢��ת��
     * */
    public int zf(String wbid, int id) {
		// TODO Auto-generated method stub
		return wb.ZF(wbid, id);
	}
  //�ϴ�ͷ��
  	public int Update_Headpic(Map m)
  	{
  		return wb.Update_headpic(m);
  	}
  /*
   * ģ����ѯ
   * */
    public List<WbBean> GetWBByTopic(String topic) {
		
		return wb.queryWBByTopic(topic);
		
	}
    /*
     * �ؼ��ֲ���
     * */
   public int insertTopic(String topic) {
		
		return wb.insertTopic(topic);
		
	}
 /*
  * �ؼ��ֲ�ѯ
  * */
  public  List<Map<String, String>> queryTopic() {
	  
	  return wb.queryTopic();
  }
  
  /*
   * �ؼ��ֲ���
   */
  public List<Map<String , String>>  chachong(String topic) {
	  
	return wb.Panduanchongfu(topic);
}
    }
