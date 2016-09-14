package com.epam.maya_semina.exceptions;

public class UnknownDriverTypeException extends RuntimeException {
	private static final long serialVersionUID = 3416986243396501283L;
	
	public UnknownDriverTypeException(String message){
		super(message);
	}

}
