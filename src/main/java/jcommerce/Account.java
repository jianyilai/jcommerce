package jcommerce;

public class Account {

	protected String username;
	protected String password;
	protected String email;
	protected String userRole;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Account(String username, String password, String email, String userRole) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
	}
}
