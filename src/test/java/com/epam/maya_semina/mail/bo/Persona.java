package com.epam.maya_semina.mail.bo;


public class Persona {

	private static final String DEFAULT = "default";
	private static final String PASSWORD = "\npassword: ";
	private static final String LOGIN = "\nlogin: ";

	private String userLogin;
	private String userPassword;
	
	public Persona(){
		this.userLogin = DEFAULT;
		this.userPassword = DEFAULT;
	}
	
	public Persona(String userLogin, String userPassword) {
		this.userLogin = userLogin;
		this.userPassword = userPassword;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	@Override
	public String toString(){
		return LOGIN + userLogin  +PASSWORD + userPassword;
	}

}