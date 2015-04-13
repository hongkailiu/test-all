package com.hongkailiu.test.app.junit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hongkailiu on 2015-04-12.
 */
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        String string1 = request.getParameter("string1");
        String string2 = request.getParameter("string2");
        String string3 = request.getParameter("string3");

        String concatenated =
                MyConcatenator.concatenate(
                        string1, string2, string3);

        response.getWriter().write(concatenated);
        response.getWriter().flush();
    }
}
