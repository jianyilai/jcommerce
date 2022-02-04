package jcommerce;

public class Account {

	protected String userName;
	protected String password;
	protected String email;
	protected String userRole;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public Account(String userName, String password, String email, String userRole) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
	}
}
