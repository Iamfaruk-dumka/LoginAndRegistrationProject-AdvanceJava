package com.tcs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			// get the client data
		
		String username=request.getParameter("username");
		String password =request.getParameter("password");
		String email =request.getParameter("email");
		
		// calling the dao layer
		boolean result=UserDao.checkLogin(username,password,email);
		
		if(result == true)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.html");
			dispatcher.forward(request, response);
		}
		else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Failed.html");
			dispatcher.forward(request, response);
		}
		
	}

}
