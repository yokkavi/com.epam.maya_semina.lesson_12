package com.epam.maya_semina.mail.factoryLetters;


import com.epam.maya_semina.mail.bo.letter.LetterInterface;
import com.epam.maya_semina.utils.LettersDataGenerator;

public class LetterCreator extends Creator{

	@Override
	public LetterInterface factoryMethod() {
		LetterInterface obj = LettersDataGenerator.getRandomeLetter();
		return obj;
	}

	@Override
	public LetterInterface factoryMethod(int num) {
		LetterInterface obj = LettersDataGenerator.getRandomeLetter(num);
		return obj;
	}

}
