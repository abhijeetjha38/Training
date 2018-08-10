package com.visa.training.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

/**
 * Servlet implementation class Doit
 */
@WebServlet("/Doit")
public class Doit extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ProductDAO  dao = new  ProductDAO();
		String xx = request.getParameter("name");
		String  yy = request.getParameter("qoh");
		float zz = Float.parseFloat(request.getParameter("price"));
		Product p = new Product(xx, zz, Integer.parseInt(yy)) ;
		dao.addNew(p);
		out.println("Added Product :"+p);
		RequestDispatcher rd = request.getRequestDispatcher("flopkart.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
