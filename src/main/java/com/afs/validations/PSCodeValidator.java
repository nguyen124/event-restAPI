package com.afs.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PSCodeValidator implements ConstraintValidator<PSCode, String> {

	public String codePrefix;

	public void initialize(PSCode code) {
		codePrefix = code.value();
	}

	public boolean isValid(String code, ConstraintValidatorContext context) {
		boolean result;
		if (code != null) {
			result = code.startsWith(codePrefix);
		} else {
			result = true;
		}
		return result;
	}

}
