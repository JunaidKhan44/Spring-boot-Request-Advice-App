/**
 * 
 */
package com.springboot.handler;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import com.springboot.exception.DuplicatesStudentRecordException;
import com.springboot.model.Student;
import com.springboot.service.RequestCaptureService;

/**
 * @author Junaid.khan
 *
 */
@RestControllerAdvice
public class RequestBodyHandler implements RequestBodyAdvice {

	@Autowired
	private RequestCaptureService  requestCaptureService;
	
	
	@Autowired
	private Tracer  tracer;
	
	
	@Override
	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return (methodParameter.getMethodAnnotations() != null) ?
		Arrays.asList(methodParameter.getMethodAnnotations())
	   .stream()
	   .anyMatch(t->t.annotationType().equals(PostMapping.class)) :false;
	}

	@Override
	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		
		return inputMessage;
	}

	@Override
	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		Span span = tracer.createSpan("afterBodyRead");
		if(!requestCaptureService.captureIncomingRequests((Student) body))
			throw new DuplicatesStudentRecordException("record already present ...!!");
		tracer.close(span);
		return body;
	}

	@Override
	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
			Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		
		return body;
	}

}
