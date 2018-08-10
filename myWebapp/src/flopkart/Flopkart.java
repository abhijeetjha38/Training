package flopkart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.visa.training.dal.ProductDAO;
import com.visa.training.domain.Product;

/**
 * Servlet implementation class Flopkart
 */
@WebServlet("/Flopkart")
public class Flopkart extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDAO pd = new ProductDAO();
		Product p = new Product();

		List<Product> l = pd.findAll();
		request.setAttribute("productlist",l);
		
		HttpSession session = request.getSession();
		Set< String >ids_aux = (Set<String>)session.getAttribute("list");
		Set<Integer> ids = ids_aux.stream().map(Integer::parseInt).collect(Collectors.toSet());
	
		List<Product>cartItems = new ArrayList<Product>();
		for(Integer x : ids ) {
			cartItems.add( pd.findOne(x) ) ;
		}
		
		request.setAttribute("cartlist",cartItems);
		RequestDispatcher rd = request.getRequestDispatcher("flopkart.jsp") ;
		rd.forward(request,response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
