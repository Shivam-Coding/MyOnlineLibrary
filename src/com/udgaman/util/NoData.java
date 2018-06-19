package com.udgaman.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoDataValidator.class)
public @interface NoData {

	String message() default "No data";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
