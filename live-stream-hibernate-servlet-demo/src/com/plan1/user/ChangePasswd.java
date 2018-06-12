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
import com.plan1.utils.StringFormatJudge;

/**
 * Servlet implementation class ChangePasswd
 */
@WebServlet("/changepasswd")
public class ChangePasswd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswd() {
        super();
        // TODO Auto-generated constructor stub
    }

    //解析邮箱连接
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String email = request.getParameter("email");
		List<User> users = HibernateUserProcess.isOk("toActivated",code ,email);
		PrintWriter out = response.getWriter();
		Map<String, String> res = new HashMap<String, String>();
		if(users.size() ==1 ) {
			User user = users.get(0);
			if(user.isActivated()) {
				res.put("status", "1");
			}else {
				res.put("status", "2" );
				res.put("msg","该用户未激活");
			}
				
		
		}
		
		if(res.isEmpty()) {
			res.put("status", "0");
			res.put("msg","操作无效");
		}
		out.print(JsonConverter.map2json(res));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newPass = request.getParameter("password");
		String email = request.getParameter("email");
		String code =request.getParameter("code");
		List<User> users = HibernateUserProcess.isOk("User.toActivated",email,code);
		PrintWriter out = response.getWriter();
		Map<String, String> res = new HashMap<String, String>();
		if(StringFormatJudge.judgeUser(newPass, 6, 32)) {
			if(users.size() ==1) {
				User user = users.get(0);
				user.setPassword( CryptoUntils.cryptoPasswd(newPass, user.getSalt()) );
				HibernateUserProcess.insertUpdateObj(user);
				res.put("status", "1");
			}
		}
		if(res.isEmpty()) {
			res.put("status", "0");
		}
		out.print(JsonConverter.map2json(res));
	}
	
}
