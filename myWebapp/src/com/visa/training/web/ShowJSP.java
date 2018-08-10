package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

/**
 * Servlet implementation class Show
 */
@WebServlet("/ShowJSP")
public class ShowJSP extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO pd = new ProductDAO();
		Product p = new Product();

		List<Product> l = pd.findAll();
		request.setAttribute("productlist",l);
		RequestDispatcher rd = request.getRequestDispatcher("productlist2.jsp") ;
		rd.forward(request,response);
		// l.forEach(System.out::println);

//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//
//		out.println("<html>");
//		out.println("<body bgcolor= pink>");
//		out.println("<h3> Hello Products are: " + "</h3>");
//		out.println("<form method =\"post\" action = \"Insert\"  >");
//		
//		out.println("<table> <tr><th>name</th><th>price</th><th>qoh</th></tr>");
//		// Iterator<List> x= new Iterator<Product>() ;
//		for (Product pr : l) {
//			out.println(
//					"<tr><td>" + "<input type =\"checkbox\" name = \"send\" value =\"" + pr.getInd() + "\"> " + pr.getName()
//							+ "</td><td>" + pr.getPrice() + pr.getInd() + "</td><td>" + pr.getQoh() + "</td></tr>");
//		}
//
//		out.println("</table>");
//
//		out.println("<input type = \"submit\"  value=\"press\"> ");
//		out.println("</form>");
//		out.println("</body></html>");

	}

}
