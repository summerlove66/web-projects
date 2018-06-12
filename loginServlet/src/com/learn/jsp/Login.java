package com.learn.jsp;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static   HashMap<String, String> validAcct = new HashMap<String,String>();
	static {
		
		validAcct.put("hui" ,"123456");
		validAcct.put("辉","234567");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = new String(request.getParameter("username").getBytes("ISO8859-1"),"UTF-8");
		String password = request.getParameter("pass");
		if (validAcct.containsKey(username)&& validAcct.get(username).equals(password) ) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("homepage.jsp");
			
		}else {
			response.sendRedirect("loginpage.jsp");
		}
		
		
		
	}

}
