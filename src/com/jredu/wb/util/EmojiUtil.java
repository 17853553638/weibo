/**
 * Title:     EmojiUtil.java
 * @Description:   TODO(��һ�仰�������ļ���ʲô) 
 * Company  �������
 * @author        �Ϲ�
 * @version        V1.0  
 * @Date           2018-3-12 ����10:47:16 
 */
package com.jredu.wb.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiUtil {

	
	/**
	 * 
	* @Title: emojiRecovery2   
	* @Description: TODO(�����ݿ�ģ�����������)   
	* @param str
	* @return
	* @throws UnsupportedEncodingException    �趨�ļ�   
	* @return String    ��������   
	* @throws
	 */
	public static String stringToEmoji(String str)
			throws UnsupportedEncodingException {
		String patternString = "\\[\\[(.*?)\\]\\]";

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(str);

		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			try {
				matcher.appendReplacement(sb,
						URLDecoder.decode(matcher.group(1), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				throw e;
			}
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
	
	/**
	 * 
	* @Title: emojiConvert1   
	* @Description: TODO(emoji����������ݿ�)   
	* @param str
	* @return
	* @throws UnsupportedEncodingException    �趨�ļ�   
	* @return String    ��������   
	* @throws
	 */
	public static String emojiToString(String str)
			throws UnsupportedEncodingException {
		
		String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";

		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			try {
				matcher.appendReplacement(sb,
						"[[" + URLEncoder.encode(matcher.group(1), "UTF-8")
								+ "]]");
			} catch (UnsupportedEncodingException e) {
				throw e;
			}
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	public static void main(String [] args) {
		String str = "[[%F0%9F%98%80]][[%F0%9F%98%80]][[%F0%9F%98%80]]";
		try {
			System.out.println(stringToEmoji(str));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
