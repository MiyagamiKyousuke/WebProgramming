package model;

import java.util.Date;

public class User {
	private int id;
	private String login_id;
	private String name;
	private Date birth_date;
	private String password;
	private String create_date;
	private String update_date;
	/**
	 * @return id
	 */


	//ログインセッションを格納するためのコンストラクタ

	public User(String login_id, String name) {

		this.login_id = login_id;
		this.name = name;
	}




	public User(int id, String login_id, String name, Date birth_date, String password, String create_date,
			String update_date) {
		this.id = id;
		this.login_id = login_id;
		this.name = name;
		this.birth_date = birth_date;
		this.password = password;
		this.create_date = create_date;
		this.update_date = update_date;
	}




	public int getId() {
		return id;
	}

	/**
	 * @param id セットする id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return login_id
	 */
	public String getLogin_id() {
		return login_id;
	}
	/**
	 * @param login_id セットする login_id
	 */
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return birth_date
	 */
	public Date getBirth_date() {
		return birth_date;
	}
	/**
	 * @param birth_date セットする birth_date
	 */
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return create_date
	 */
	public String getCreate_date() {
		return create_date;
	}
	/**
	 * @param create_date セットする create_date
	 */
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	/**
	 * @return update_date
	 */
	public String getUpdate_date() {
		return update_date;
	}
	/**
	 * @param update_date セットする update_date
	 */
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

}
