package com.visa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionDemoServlet
 */
@WebServlet("/SessionDemoServlet")
public class SessionDemoServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	HttpSession session = request.getSession();
	Integer count = (Integer) session.getAttribute("count");
	if(count==null) {
		count = 1 ;
	}
	else {
		count = count  + 1 ;
	}
	session.setAttribute("count",count);
	response.setContentType("text/plain");
	PrintWriter out = response.getWriter() ;
	out.println(count);
}

}
