package com.gsxm;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.gsxm.util.JsonUtils;
import com.gsxm.util.SMSUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

	@Value("${SMSTEMPLATE}")
	private String SMSTEMPLATE;

	@Value("@{ACCRSSKRYID}")
	static String ACCRSSKRYID;

	@Value("@{ACCRSSKRYSECRET}")
	static String ACCRSSKRYSECRET;

	@Test
	public void contextLoads() throws ClientException {
		int code  = (int) (Math.random() * 10000);
		Map map=new HashMap();
		map.put("code",String.valueOf(code));
		String json = JsonUtils.objectToJson(map);
		SendSmsResponse response =SMSUtils.sendSms("13699440439","SMS_140050101",json,"LTAIUrfI3u2bjhBo","lbO5KCFjzsVO2sdD7TacQNzvFDuTf8"); //发短信

		System.out.println("短信接口返回的数据----------------");
		System.out.println("Code=" + response.getCode());
		System.out.println("Message=" + response.getMessage());
		System.out.println("RequestId=" + response.getRequestId());
		System.out.println("BizId=" + response.getBizId());
	}

}
