package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdate() {
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
		//DAOで出力
		UserDao userDao = new UserDao();
		User user = userDao.detailPrint(id);

		request.setAttribute("user", user);
		// JSPへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// リクエストパラメータの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		// リクエストパラメータの入力項目を取得
		String loginId = request.getParameter("login");
		String password = request.getParameter("pass");
		String passwordCheck = request.getParameter("passCheck");
		String name = request.getParameter("userName");
		String birthDate = request.getParameter("birth");
		//パスワードが確認と一致していなかったら
		if (!(password.equals(passwordCheck))) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");
			//DAOで出力
			UserDao userDao = new UserDao();
			User user = userDao.detailPrint(id);

			request.setAttribute("user", user);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_update.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//一つでも入力項目が入力されていなかったら

		if (name.equals("") ||
				birthDate.equals("")) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");
			//DAOで出力
			UserDao userDao = new UserDao();
			User user = userDao.detailPrint(id);

			request.setAttribute("user", user);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_update.jsp");
			dispatcher.forward(request, response);
			return;

		}

		//ハッシュを生成したい元の文字列
		String source = password;
		//ハッシュ生成前にバイト配列に置き換える際のCharset
		Charset charset = StandardCharsets.UTF_8;
		//ハッシュアルゴリズム
		String algorithm = "MD5";

		//ハッシュ生成処理
		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);
		System.out.println(result);

		UserDao userDao = new UserDao();
		boolean flag = true;
		if (password.equals("")) {
			flag = userDao.noPassUpdateInfo(loginId, name, birthDate);
		} else {
			flag = userDao.updateInfo(loginId, name, birthDate, result);
		}
		//ログインIDの重複
		if (flag == false) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");

			// URLからGETパラメータとしてIDを受け取る
			String id = request.getParameter("id");
			//DAOで出力
			User user = userDao.detailPrint(id);

			request.setAttribute("user", user);
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_update.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//リダイレクト
		response.sendRedirect("UserPeople");
	}

}
