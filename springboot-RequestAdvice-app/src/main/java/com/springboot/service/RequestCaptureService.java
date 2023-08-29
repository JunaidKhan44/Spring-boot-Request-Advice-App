/**
 * 
 */
package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.model.AddressEntity;
import com.springboot.model.Student;
import com.springboot.repository.RequestCaptureRepository;

/**
 * @author Junaid.khan
 *
 */
@Service
public class RequestCaptureService {
	
	@Autowired
	private RequestCaptureRepository  repository;
	
	@Autowired
	private Tracer tracer;
	
	public boolean captureIncomingRequests(Student student) {
		Span span = tracer.createSpan("captureIncomingRequests");
		AddressEntity address = student.getAddressEntity();
		AddressEntity addressEntity= new AddressEntity();
		addressEntity.setCity(address.getCity());
		addressEntity.setDoorNo(address.getDoorNo());
		addressEntity.setState(address.getState());
		addressEntity.setStreet(address.getStreet());
		addressEntity.setZipCode(address.getZipCode());
		tracer.close(span);
		
		return  repository.captureIncomingRequests(
				student.getId(),
				student.getLastName(),
				addressEntity,
				student.getAge(),
				student.getFirstName(),
				student.getMajor().Maths,
				//UUIDs.timeBased(),
				generateVerifyValue(student)
				);
		
	}
	
	
	private String generateVerifyValue(Student student) {
		//.hashCode()
		return student.getId()+student.getAddressEntity().getZipCode();
	}

}
