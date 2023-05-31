package com.tcs;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			
			//Dao layer
			ResultSet set =UserDao.listOfUser();
			
			if(set!=null)
			{
				List<User> users = new ArrayList<>();
				while(set.next())
				{
					User user = new User(set.getString(1),set.getString(2),set.getString(3),set.getString(4));
					
					users.add(user);
				}
				
			request.setAttribute("users", users );
			RequestDispatcher dispatcher = request.getRequestDispatcher("veiwsuccess.jsp");
			dispatcher.forward(request, response);
			
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	

}
