package com.mypack.rest;

import java.io.IOException;

import javax.ws.rs.Path;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
public class RestFilter implements ContainerRequestFilter {
	
	@Context
    private ResourceInfo resourceInfo;
	@Override
	public void filter(ContainerRequestContext containerRequestContext) throws IOException {
		System.out.println(resourceInfo.getResourceClass().isAnnotationPresent(Path.class));
	}
}
