package com_fanghao_sms;

import java.net.URLEncoder;
import java.util.Random;

import com_fanghao_sms.Config;
import com_fanghao_sms.HttpUtil;

/**
 *验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "1361305****";
	private static String smsContent = "【嘉宏科技】尊敬的用户，您的验证码为";
 
	
	/**
	 * 验证码通知短信
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

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	}
}

