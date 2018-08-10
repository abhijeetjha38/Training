package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWordServlet
 */
@WebServlet("/hello")   // it let's know about the flow !! 
// before this we were mapping link to servlet !! 
public class HelloWordServlet extends HttpServlet {
	int count = 0 ;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String color = request.getParameter("color");
		if(color==null)
			color = "pink" ;
		out.println( " <html >" );
		count++;
		out.println("<body  bgcolor=" +color+ "  >");
		out.println(" Hello the time is " + new Date().toString());
		out.println( "Page hits ::" + count );
		out.println("</body>");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		// i want both my request and response to behave in the same manner !! 
	}

}
