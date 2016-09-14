package com.epam.maya_semina.mail.factoryLetters;

import java.util.ArrayList;
import java.util.ResourceBundle;

import com.epam.maya_semina.mail.bo.letter.LetterInterface;

public class ArrayLettersCreator {
	
	public static ResourceBundle resourceBundle;
	
	public static ArrayList<LetterInterface> getArrayList() {
		ArrayList<LetterInterface> list = new ArrayList<LetterInterface>();
		
		Creator[] creators = {new LetterCreator(), new LetterWithSignatureCreator(),  new LetterWithWelcomeCreator(), new LetterCreator()};
		
		for (int i = 0; i < creators.length; i++) {
			LetterInterface obj = creators[i].factoryMethod(i);
			list.add(obj);
		}
		
		return list;
	}
}
