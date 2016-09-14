package com.epam.maya_semina.mail.factoryLetters;

import com.epam.maya_semina.mail.bo.letter.LetterInterface;

public abstract class Creator {
	public abstract LetterInterface factoryMethod();
	public abstract LetterInterface factoryMethod(int num);
}
