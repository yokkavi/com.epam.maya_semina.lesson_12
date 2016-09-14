package com.epam.maya_semina.mail.builder;

public class UserBuilder extends BaseBuilder {

	private static final String ÒÅÑÒ_ÌÀÈË_ÁÎÊÑ_ÏÈÑÜÌÎ_ĞÔ = "òåñò_ìàèë_áîêñ@Ïèñüìî.ĞÔ";
	private static final String _1627993445 = "1627993445";

	@Override
	public void buildLogin() {
		persona.setUserLogin(ÒÅÑÒ_ÌÀÈË_ÁÎÊÑ_ÏÈÑÜÌÎ_ĞÔ);
	}

	@Override
	public void buildPassword() {
		persona.setUserPassword(_1627993445);

	}

}
