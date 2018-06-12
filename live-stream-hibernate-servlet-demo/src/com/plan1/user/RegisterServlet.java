package com.plan1.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.plan1.dao.HibernateUserProcess;
import com.plan1.model.Rank;
import com.plan1.model.User;
import com.plan1.model.UserOrder;
import com.plan1.utils.CryptoUntils;
import com.plan1.utils.JsonConverter;
import com.plan1.utils.StringFormatJudge;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Map<String, String> res = new HashMap<String, String>();
		if (!registerFormatFilter(userName, password, email)
				|| HibernateUserProcess.isOk("User.isRight", email, userName).size() > 0) {

			res.put("status", "0");
			res.put("msg", "输入错误");

		} // bad request process

		else {
			res.put("status", "1");
			String salt = CryptoUntils.genSalt();

			User user = new User(userName, email, CryptoUntils.cryptoPasswd(password, salt), salt);
			Rank rank = new Rank(1, 0);
			rank.getOrders().add(new UserOrder(11, 1200));
			user.setRank(rank);

			System.out.println("USER :" + user + "  准备插入");
			HibernateUserProcess.insertUpdateObj(user);

		}
		out.print(JsonConverter.map2json(res));

	}

	// 对用户名或邮箱格式要求
	protected boolean registerFormatFilter(String userName, String password, String email) {

		if (!email.contains("@")) {
			return false;
		}

		return StringFormatJudge.judgeUser(userName, 6, 16) && StringFormatJudge.judgeUser(password, 8, 16)
				&& StringFormatJudge.judgeUser(email.replaceAll("@|\\.", ""), 10, 32);

	}

}
