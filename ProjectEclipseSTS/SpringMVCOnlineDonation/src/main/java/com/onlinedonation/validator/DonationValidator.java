package com.onlinedonation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.onlinedonation.bean.Donation;

public class DonationValidator implements Validator {

	@Override
	public boolean supports(Class<?> type) {
		return Donation.class.isAssignableFrom(type);
	}

	@Override
	public void validate(Object object, Errors error) {
		Donation donation = (Donation) object;
		ValidationUtils.rejectIfEmptyOrWhitespace(error, "amount", "required.amount", "The amount field is required");

		ValidationUtils.rejectIfEmptyOrWhitespace(error, "creditCard", "required.creditCard",
				"The credit Card field is required");

		if (donation.getIdInstitution().compareTo(new Integer(0)) == 0) {
			error.rejectValue("idInstitution", "required.idInstitution", "Have to select institution");
		}

		if (donation.getTypeCreditCard() == 'S') {
			error.rejectValue("typeCreditCard", "required.typeCreditCard", "Have to select a type");
		}

	}

}
