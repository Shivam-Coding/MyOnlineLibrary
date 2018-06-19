package com.udgaman.util;

import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;

import org.springframework.web.multipart.MultipartFile;

public class NoDataValidator implements ConstraintValidator<NoData, MultipartFile>{

	@Override
	public void initialize(NoData arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(MultipartFile data, ConstraintValidatorContext arg1) {
		
		String s = data.getOriginalFilename();
		
		if(data.getSize() == 0 || !(s.substring(s.length()-3).equalsIgnoreCase("PDF"))){
			return false;
		}else{
			return true;
		}
		
	}

}
