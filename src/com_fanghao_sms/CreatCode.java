package com_fanghao_sms;

import java.util.Random;

public class CreatCode {
	//生成验证码
	public static String RandomMobileString(int length){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i=0;i<length;i++) {
            int q = new Random().nextInt(10);
            stringBuffer.append(q);
        }
        return stringBuffer.toString();
    }
		

}
