/**
 * 
 */
package com.springboot.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.springboot.model.Student;

/**
 * @author Junaid.khan
 *
 */
public class ResponseBodyHandler implements ResponseBodyAdvice<Student> {

	@Autowired
	private Tracer tracer;
	
	
	
	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
	
		return false;
	}

	@Override
	public Student beforeBodyWrite(Student body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		Span span= tracer.createSpan("afterBodyRead");
		tracer.close(span);
		return null;
	}

}
