package com.mypack.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class MyRestException implements ExceptionMapper<MyException> {
	
	@Override
	public Response toResponse(MyException exception) {
		
		System.out.println(exception.toString());
		return Response.status(exception.getStatusCode())
		        .entity(exception.getMessage()).type("text/plain")
		        .build();
	}
}
