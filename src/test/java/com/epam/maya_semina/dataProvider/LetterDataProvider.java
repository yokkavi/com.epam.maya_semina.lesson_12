package com.epam.maya_semina.dataProvider;

import java.util.Locale;
import java.util.ResourceBundle;

import org.testng.annotations.DataProvider;

public class LetterDataProvider {
	@DataProvider
	public static Object[][] getData() {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("config", Locale.getDefault());
		Object[][] outputDataset = {
				{ resourceBundle.getString("LETTER_0_TO"), resourceBundle.getString("LETTER_0_THEME"),
						resourceBundle.getString("LETTER_0_BODY") },
				{ resourceBundle.getString("LETTER_1_TO"), resourceBundle.getString("LETTER_1_THEME"),
						resourceBundle.getString("LETTER_1_BODY") },
				{ resourceBundle.getString("LETTER_2_TO"), resourceBundle.getString("LETTER_2_THEME"),
						resourceBundle.getString("LETTER_2_BODY") },
				{ resourceBundle.getString("LETTER_3_TO"), resourceBundle.getString("LETTER_3_THEME"),
						resourceBundle.getString("LETTER_3_BODY") }, };

		return outputDataset;
	}

}
