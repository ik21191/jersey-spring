package com.mypack.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.JsonArray;
import com.sun.jersey.core.util.Base64;

@Path("/authorize")
public class UserAuthorization {
	
	@POST
	@Path("/validate")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authorizeUser(@FormParam("user_id") String userId, 
			@FormParam("user_password") String userPassword) {
		if(userId == null || userPassword == null) {
			return Response.status(403).build();
		}
		
		if(userId.equalsIgnoreCase("test") && userPassword.equalsIgnoreCase("test")) {
			String bytes = userId + ":" + userPassword;
			String token = Base64.encode(bytes.getBytes()).toString();
			JsonArray jsonArray = new JsonArray();
			jsonArray.add(token);
			return Response.status(200).entity(jsonArray.toString()).build();
		}
		return null;
	}

}
