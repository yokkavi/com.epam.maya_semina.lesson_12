package com.epam.maya_semina.mail.bo.letter;

public class LetterWithSignature extends Letter{

	private static final String STRING = " ";
	private LetterInterface letter;
	String text;
	
	public LetterWithSignature(LetterInterface letter, String text) {
		super(letter.getTo(), letter.getTheme(), letter.getBody());
		this.text = text;
		this.letter = letter;
		this.letter = getLetter();
		body = letter.getBody();
	}
	
	public String getBody(){
		return letter.getBody() + STRING + text;
	}

	public LetterInterface getLetter() {
		this.letter = new Letter(letter.getTo(), letter.getTheme(), letter.getBody());
		return this.letter;
	}

}