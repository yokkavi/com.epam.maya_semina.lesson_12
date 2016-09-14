package com.epam.maya_semina.mail.factoryLetters;

import com.epam.maya_semina.mail.bo.letter.LetterInterface;
import com.epam.maya_semina.mail.bo.letter.LetterWithWelcome;
import com.epam.maya_semina.utils.LettersDataGenerator;

public class LetterWithWelcomeCreator extends Creator {

	private static final String DEAR_N = "Dear n!";

	@Override
	public LetterInterface factoryMethod() {
		LetterInterface obj = LettersDataGenerator.getRandomeLetter();
		LetterInterface letter1 = new LetterWithWelcome(obj, DEAR_N);
		return letter1;
	}

	@Override
	public LetterInterface factoryMethod(int num) {
		LetterInterface obj = LettersDataGenerator.getRandomeLetter(num);
		LetterInterface letter1 = new LetterWithWelcome(obj, DEAR_N);
		return letter1;
	}

}
