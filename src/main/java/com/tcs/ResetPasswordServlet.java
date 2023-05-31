package com.tcs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResetPasswordServlet")
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public ResetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//getting client data
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String cpassword=request.getParameter("cpassword");
		
		if(password.equals(cpassword))
		{
			int  res = UserDao.passwordReset(email,cpassword);
		
		if(res ==1)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("success.html");
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("Failed.html");
			dispatcher.forward(request, response);
		}
		
		}
	}

}
