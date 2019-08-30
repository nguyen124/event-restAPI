package com.afs.validations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PSCodeValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PSCode {

	public String value() default "PS";

	public String message() default "PS code should start with PS";

	public Class<?>[] groups() default {};

	public Class<? extends Payload>[] payload() default {};
}
