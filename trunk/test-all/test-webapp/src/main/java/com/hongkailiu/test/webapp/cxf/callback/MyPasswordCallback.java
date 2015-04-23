package com.hongkailiu.test.webapp.cxf.callback;

import org.apache.log4j.Logger;
import org.apache.ws.security.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

public class MyPasswordCallback implements CallbackHandler {

    static Logger logger = Logger.getLogger(MyPasswordCallback.class);

    @Override public void handle(Callback[] callbacks)
        throws IOException, UnsupportedCallbackException {
        logger.debug("MyPasswordCallback.handle(): ");
        WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
        String pw = pc.getPassword();
        String idf = pc.getIdentifier();
        logger.debug("MyPasswordCallback.handle(): pw: " + pw + ", idf: " + idf);
        //        if (!"admin".equals(idf) || !"123456".equals(pw)) {
        //            throw new SecurityException("鉴权失败！");
        //        }

        //在真实环境中，肯定是用dao来和后端的数据库反应得到用户名和密码
        if ("admin".equals(idf)) {
            // set the password on the callback. This will be compared to the
            // password which was sent from the client.
            pc.setPassword("123456");
        }

    }

}
