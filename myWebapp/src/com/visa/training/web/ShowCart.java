package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/ShowCart")
public class ShowCart extends HttpServlet {
	ProductDAO dao = new ProductDAO();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(" <html> <body> " );
		HttpSession session = request.getSession();
		Set< String >ids_aux = (Set<String>)session.getAttribute("list");
		Set<Integer> ids = ids_aux.stream().map(Integer::parseInt).collect(Collectors.toSet());
		if(ids==null) {
			out.println("nothing there in the cart ");
		}
		else {
			List<Product> all = ids.stream().map(dao::findOne).collect(Collectors.toList());
			all.forEach(out::println);
		}
		out.println( " </body></html> " );
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
