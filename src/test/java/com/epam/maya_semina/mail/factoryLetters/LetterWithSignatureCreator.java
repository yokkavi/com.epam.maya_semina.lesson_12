package com.epam.maya_semina.mail.factoryLetters;

import com.epam.maya_semina.mail.bo.letter.LetterInterface;
import com.epam.maya_semina.mail.bo.letter.LetterWithSignature;
import com.epam.maya_semina.utils.LettersDataGenerator;

public class LetterWithSignatureCreator extends Creator {

	private static final String WITH_RESPECT_ME = "With respect, me.";

	@Override
	public LetterInterface factoryMethod() {
		LetterInterface obj = LettersDataGenerator.getRandomeLetter();
		LetterInterface letter1 = new LetterWithSignature(obj, WITH_RESPECT_ME);
		return letter1;
	}

	@Override
	public LetterInterface factoryMethod(int num) {
		LetterInterface obj = LettersDataGenerator.getRandomeLetter(num);
		LetterInterface letter1 = new LetterWithSignature(obj, WITH_RESPECT_ME);
		return letter1;
	}

}
