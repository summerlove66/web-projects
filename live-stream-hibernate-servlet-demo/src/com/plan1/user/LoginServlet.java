package com.plan1.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plan1.dao.HibernateUserProcess;
import com.plan1.model.User;
import com.plan1.utils.CryptoUntils;
import com.plan1.utils.JsonConverter;



@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Map<String, String> res = new HashMap<String, String>();
		
		List<User> users = HibernateUserProcess.isOk("User.isExist",new String[] {email,userName});
		if(users.size() ==1) {
			User user = users.get(0);
		String userSalt = user.getSalt();
		String userPassword = user.getPassword();
		if(userPassword.equals( CryptoUntils.cryptoPasswd(password, userSalt))) {
			res.put("status", "1");
		}
					
		}
		if(res.isEmpty()) {
			res.put("status", "0");
			res.put("msg", "用户名或密码错误");
		}
		
		out.print(JsonConverter.map2json(res));
	}

}
