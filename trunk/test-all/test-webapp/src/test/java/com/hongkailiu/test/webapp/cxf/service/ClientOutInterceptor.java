package com.hongkailiu.test.webapp.cxf.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;

import com.hongkailiu.test.webapp.cxf.interceptor.MyInterceptor;

public class ClientOutInterceptor extends AbstractPhaseInterceptor<Message> {

	private String username;
	private String password;
	
	public ClientOutInterceptor(String username, String password) {
		super(Phase.PRE_STREAM);
		this.username = username;
		this.password = password;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handleMessage(Message message) throws Fault {
		Map<String, List<String>> headers = (Map<String, List<String>>)message.get(Message.PROTOCOL_HEADERS);
        if (headers == null) {
        	headers = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
            message.put(Message.PROTOCOL_HEADERS, headers);
        }
		// modify headers
        List<String> values = new ArrayList<String>();
        values.add(username);
        headers.put(MyInterceptor.USERNAME_HEADER_KEY, values);
        values = new ArrayList<String>();
        values.add(password);
        headers.put(MyInterceptor.PASSWORD_HEADER_KEY, values);
	}

}
