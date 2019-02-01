package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserDelete() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//セッションの確認(sessionがnullならログインに戻る)
		// HttpSessionインスタンスの取得
		HttpSession session = request.getSession();

		if (session.getAttribute("user") == null) {
			response.sendRedirect("Login");
			return;
		}
		// URLからGETパラメータとしてIDを受け取る
		String id = request.getParameter("id");

		System.out.println(id);

		UserDao userdao = new UserDao();
		User user = userdao.detailPrint(id);

		request.setAttribute("user", user);

		// JSPへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_delete.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		////リクエストパラメータを取得(ログインIDとボタン)
		String login_id = request.getParameter("login"); //ログインID
		String btn = request.getParameter("btn"); //ボタン
		//
		if (btn.equals("キャンセル")) {
			//リダイレクト
			response.sendRedirect("UserPeople");
			return;
		}

		UserDao userDao = new UserDao();
		userDao.deleteInfo(login_id);

		//リダイレクト
		response.sendRedirect("UserPeople");
	}

}
