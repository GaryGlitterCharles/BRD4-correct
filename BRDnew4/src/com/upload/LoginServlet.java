package com.upload;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String dropDown = request.getParameter("MakerChecker");
		if(dropDown.equals("maker"))
		{
			
			if (DataBaseDao.validate(username, password)) {
				 
				
				 RequestDispatcher requestDispatcher =
				 request.getRequestDispatcher("makerNavigate.html");
				 requestDispatcher.forward(request, response);
			}
			else {

				out.println("Username or Password incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("login.html");
				rs.include(request, response);
			}
		}
		if(dropDown.equals("checker"))
		{
			
			if (DataBaseDao.validate(username, password)) {
				 
				
				 RequestDispatcher requestDispatcher =
				 request.getRequestDispatcher("checker.html");
				 requestDispatcher.forward(request, response);
			}
			else {

				out.println("Username or Password incorrect");
				RequestDispatcher rs = request.getRequestDispatcher("checker.html");
				rs.include(request, response);
			}
		}
		 
		

	}

}