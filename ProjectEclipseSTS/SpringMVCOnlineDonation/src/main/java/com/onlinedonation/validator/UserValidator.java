package com.onlinedonation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlinedonation.bean.Usuario;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> type) {
		return Usuario.class.isAssignableFrom(type);
	}

	@Override
	public void validate(Object object, Errors error) {
		// Usuario usuario = (Usuario) object;
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "userName", "required.userName",
				"The user name field is required");

		ValidationUtils.rejectIfEmptyOrWhitespace(error, "password", "required.password",
				"The password field is required");

	}

}
