package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.User;

public class UserDao {
	public User findLoginInfo(String loginId, String pass) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			// SELECT文を準備
			String sql = "SELECT * FROM user WHERE login_id = ? and password = ?";
			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, pass);

			ResultSet rs = pStmt.executeQuery();

			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {
				return null;
			}

			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

	}

	public List<User> findAll() {
		Connection conn = null;

		conn = DBManager.getConnection();
		List<User> userList = new ArrayList<>();

		try {

			// データベースへ接続
			conn = DBManager.getConnection();

			//SELECT文準備
			String sql = "SELECT * FROM user WHERE login_id != 'admin'";

			// SELECTを実行し、結果表を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("ID");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
				userList.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}

	public boolean newInsert(String login_id, String name, String birth_date, String password) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			// INSERT文を準備
			String sql = "INSERT INTO USER (login_id,name,birth_date,password,create_date,update_date) VALUES (?,?,?,?,now(),now())";

			// INSERT文を実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			pStmt.setString(2, name);
			pStmt.setString(3, birth_date);
			pStmt.setString(4, password);

			int rs = pStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}

		}
		return true;
	}

	public User detailPrint(String id) {
		Connection conn = null;

		conn = DBManager.getConnection();
		// SELECT文を準備
		try {
			String sql = "SELECT * FROM user WHERE ID = ?";
			// SELECTを実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, id);
			ResultSet rs = pStmt.executeQuery();
			// 主キーに紐づくレコードは1件のみなので、rs.next()は1回だけ行う
			if (!rs.next()) {

				return null;
			}
			int idname = rs.getInt("ID");
			String loginId = rs.getString("login_id");
			String name = rs.getString("name");
			Date birthDate = rs.getDate("birth_date");
			String password = rs.getString("password");
			String createDate = rs.getString("create_date");
			String updateDate = rs.getString("update_date");
			User user = new User(idname, loginId, name, birthDate, password, createDate, updateDate);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}

	}

	public boolean noPassUpdateInfo(String login_id, String name, String birth_date) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			// UPDATE文を準備
			String sql = "UPDATE user SET name=?,birth_date=?,update_date=now() WHERE login_id=?";
			// UPDATE文を実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birth_date);
			pStmt.setString(3, login_id);
			int rs = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;
	}

	public boolean updateInfo(String login_id, String name, String birth_date, String password) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			// UPDATE文を準備
			String sql = "UPDATE user SET name=?,birth_date=?,password=?,update_date=now() WHERE login_id=?";
			// UPDATE文を実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, name);
			pStmt.setString(2, birth_date);
			pStmt.setString(3, password);
			pStmt.setString(4, login_id);
			int rs = pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return true;

	}

	public void deleteInfo(String login_id) {
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			// UPDATE文を準備
			String sql = "DELETE FROM user WHERE login_id=?";
			// UPDATE文を実行し、結果表を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login_id);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return;
				}
			}
		}
		return;

	}

	public List<User> findSelect(String login_id,String names,String date_start,String date_end){
		Connection conn = null;
		List<User> userList = new ArrayList<>();
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM user WHERE login_id != 'admin'";

			if(!login_id.equals("")) {
				sql += " AND login_id='" + login_id + "'";
			}
			if(!names.equals("")) {
				sql += "AND name LIKE '%" +names + "%'";
			}
			if(!date_start.equals("")) {
				sql += "AND birth_date >= '" + date_start + "'";
			}
			if(!date_end.equals("")) {
				sql += "AND birth_date <= '" + date_end + "'";
			}


			 // SELECTを実行し、結果表を取得
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
				int id = rs.getInt("ID");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthDate = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthDate, password, createDate, updateDate);
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			// データベース切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}



		return userList;

	}

}
