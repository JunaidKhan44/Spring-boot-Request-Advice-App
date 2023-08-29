package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.exception.DuplicatesStudentRecordException;
import com.springboot.model.Student;

import io.micrometer.common.util.StringUtils;

/**
 * @author Junaid.khan
 *
 */

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@PostMapping
	public String saveStudentInformation(@RequestBody Student student) {
	
		if(StringUtils.isBlank(student.getLastName())){
			throw new DuplicatesStudentRecordException("last name is required");
		}
		return "Data is saved";
		
	}

	//for each separate controller
//	@ExceptionHandler
//	public String invalidFieldException(InvalidFieldException exception) {
//		return exception.getMessage();
//	}
	
}
