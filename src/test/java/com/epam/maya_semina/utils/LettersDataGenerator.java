package com.epam.maya_semina.utils;

import java.util.Locale;
import java.util.ResourceBundle;

import com.epam.maya_semina.mail.bo.letter.Letter;

public class LettersDataGenerator {

	private static final int BODY_DATASET = 2;
	private static final int THEME_DATASET = 1;
	private static final int TO_DATASET = 0;
	private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config", Locale.getDefault());

	
	private static Object[][] outputDataset = {
			{ resourceBundle.getString("LETTER_0_TO"), resourceBundle.getString("LETTER_0_THEME"),
					resourceBundle.getString("LETTER_0_BODY") },
			{ resourceBundle.getString("LETTER_1_TO"), resourceBundle.getString("LETTER_1_THEME"),
					resourceBundle.getString("LETTER_1_BODY") },
			{ resourceBundle.getString("LETTER_2_TO"), resourceBundle.getString("LETTER_2_THEME"),
					resourceBundle.getString("LETTER_2_BODY") },
			{ resourceBundle.getString("LETTER_3_TO"), resourceBundle.getString("LETTER_3_THEME"),
					resourceBundle.getString("LETTER_3_BODY") }, };
	
	public static int getRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min) + min);
	}

	public static Letter getRandomeLetter() {

		int numTo = getRandomInt(0, outputDataset.length);
		int numTheme = getRandomInt(0, outputDataset.length);
		int numBody = getRandomInt(0, outputDataset.length);

		String to = (String) outputDataset[numTo][TO_DATASET];
		String theme = (String) outputDataset[numTheme][THEME_DATASET];
		String body = (String) outputDataset[numBody][BODY_DATASET];

		Letter letter = new Letter(to, theme, body);

		return letter;
	}

	public static Letter getRandomeLetter(int num) {
		if (num <= 3 && num >= 0) {
			int numBody = getRandomInt(0, outputDataset.length);
			String to = (String) outputDataset[num][TO_DATASET];
			String theme = (String) outputDataset[num][THEME_DATASET];
			String body = (String) outputDataset[numBody][BODY_DATASET];
			Letter letter = new Letter(to, theme, body);
			return letter;
		}

		else {
			return getRandomeLetter();
		}
	}

}
