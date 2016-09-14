package com.epam.maya_semina.mail.bo.letter;

public class Letter implements LetterInterface{
	
	private static final String BODY2 = "\nbody: ";
	private static final String THEME2 = "\ntheme: ";
	private String to;
	private String theme;
	protected String body;
	
	public Letter(String to, String theme, String body) {
		this.setTo(to);
		this.setTheme(theme);
		this.setBody(body);
	}
	
	public Letter() {
		this.setTo("");
		this.setTheme("");
		this.setBody("");
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTo() {
		return to;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;	
	}

	public void setTo(String to) {
		if (to!=null){
			to.contains("/n/n");
		}
		this.to = to;
	}
	
	@Override
	public String toString() {
		return "to: " + getTo() + THEME2 + getTheme() + BODY2 + getBody();
	}
	
	public LetterInterface getLetter() {
		return this;
	}

}
