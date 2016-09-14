package com.epam.maya_semina.ui.webDriver;

public enum DriverTypes {
FIREFOX("firefox"), IE("internet explorer"), CHROME("chrome");
	private String driverName;

	DriverTypes(String driverName){
		this.driverName = driverName;
	}
	
	public String getDriverName() {
		return driverName;
	}
}
