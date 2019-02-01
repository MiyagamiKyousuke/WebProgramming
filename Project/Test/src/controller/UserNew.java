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

/**
 * Servlet implementation class UserNew
 */
@WebServlet("/UserNew")
public class UserNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserNew() {
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
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_new.jsp");
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
		String passwordCheck = request.getParameter("pass2");
		String name = request.getParameter("user_name");
		String birthDate = request.getParameter("birth");
		//パスワードが確認と一致していなかったら
		if (!(password.equals(passwordCheck))) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_new.jsp");
			dispatcher.forward(request, response);
		}
		//一つでも入力項目が入力されていなかったら

		if ((loginId.equals("")) ||
				password.equals("") ||
				name.equals("") ||
				birthDate.equals("")) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_new.jsp");
			dispatcher.forward(request, response);

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
		flag = userDao.newInsert(loginId, name, birthDate, result);
		//ログインIDの重複
		if (flag == false) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			// フォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_new.jsp");
			dispatcher.forward(request, response);
		}

		response.sendRedirect("UserPeople");

	}

}
