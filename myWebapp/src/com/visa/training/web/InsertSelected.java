package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class InsertSelected
 */
@WebServlet("/Insert")
public class InsertSelected extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] selected = request.getParameterValues("send");
		List<String> l = new ArrayList<>(Arrays.asList(selected));
		response.setContentType("text/plain");
		response.getWriter().println(Arrays.asList(selected));
		HashSet<String> unique = new HashSet<String>();
		for (String yy : l) {
			unique.add(yy);
		}
		HttpSession session = request.getSession();
		Set<String> tt = (Set<String>) session.getAttribute("list");
		// Set< Integer > xyz = Stream.of(l).map(Integer::parseInt).collect(Collectors.toSet());  array to list using streams 
		if (tt == null) {
			tt = unique;
		} else {
			for (String xx : unique) {
				tt.add(xx);
			}
		}
		session.setAttribute("list", tt);
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		tt.forEach(out::println);
		out.println("<a href='home.html'>Back</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
