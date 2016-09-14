package com.epam.maya_semina.mail.builder;

import com.epam.maya_semina.mail.bo.Persona;

public abstract class BaseBuilder {

	protected Persona persona = new Persona();

	public Persona getPersona() {
		return persona;
	}

	public abstract void buildLogin();

	public abstract void buildPassword();

}
