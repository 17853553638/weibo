package com_fanghao_sms;

import java.net.URLEncoder;
import java.util.Random;

import com_fanghao_sms.Config;
import com_fanghao_sms.HttpUtil;

/**
 *��֤��֪ͨ���Žӿ�
 * 
 * @ClassName: IndustrySMS
 * @Description: ��֤��֪ͨ���Žӿ�
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "1361305****";
	private static String smsContent = "���κ�Ƽ����𾴵��û���������֤��Ϊ";
 
	
	/**
	 * ��֤��֪ͨ����
	 */
	public static void execute(String to,String code)
	{
		String tmpSmsContent = null;
	    try{
	    	smsContent = smsContent + code;
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // �ύ����
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}

