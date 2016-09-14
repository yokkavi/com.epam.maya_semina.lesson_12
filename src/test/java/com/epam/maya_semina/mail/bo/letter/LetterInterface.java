package com.epam.maya_semina.mail.bo.letter;


public interface LetterInterface {

	public LetterInterface getLetter();
	
	public String getBody();

	public void setBody(String body);

	public String getTo();

	public String getTheme();

	public void setTheme(String theme);

	public void setTo(String to);
	
	public String toString();
}
