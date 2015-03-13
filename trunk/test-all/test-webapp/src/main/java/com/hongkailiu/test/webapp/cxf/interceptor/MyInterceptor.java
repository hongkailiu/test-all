package com.hongkailiu.test.webapp.cxf.interceptor;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.log4j.Logger;

public class MyInterceptor extends AbstractPhaseInterceptor<Message> {

	static Logger logger = Logger.getLogger(MyInterceptor.class);
	
	public final static String USERNAME_HEADER_KEY = "username";
	public final static String PASSWORD_HEADER_KEY = "password";

	public MyInterceptor() {
		super(Phase.RECEIVE);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(Message message) throws Fault {
		String username = null;
		String password = null;
		
		Map<String, List<String>> headers = (Map<String, List<String>>) message
				.get(Message.PROTOCOL_HEADERS);

		if (headers != null) {
			for (String key : headers.keySet()) {
				List<String> values = headers.get(key);
				if (USERNAME_HEADER_KEY.equals(key)&&values!=null&&values.size()>0){
					username = values.get(0);
				}
				if (PASSWORD_HEADER_KEY.equals(key)&&values!=null&&values.size()>0){
					password = values.get(0);
				}
				if (values != null) {
					for (String value : values) {
						logger.debug("handleMessage: " + key + " : " + value);
					}
				}
			}
		}
		
		if (!authenticate(username,password)){
			Fault fault = new Fault(new SecurityException("authenticate failed"));
			fault.setStatusCode(403);
			throw fault;
		}

	}

	private boolean authenticate(String username, String password) {
		// 真实场景下使用DAO即可
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(username)) {
			return false;
		}
		if ("admin".equals(username)&&"123456".equals(password)) {
			return true;
		}
		return false;
	}

}
