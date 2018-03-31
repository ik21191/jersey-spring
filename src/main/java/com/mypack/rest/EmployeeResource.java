package com.mypack.rest;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;

import com.mypack.beans.EmpDetail;
import com.mypack.beans.Employee;

@Path("/employee")
public class EmployeeResource {
	private static final Logger log = Logger.getLogger(EmployeeResource.class);
	
	@POST
	@Path("/detail/{empId}")
	/**This method will produce both xml and json response. In browser we need to set header as Accept: application/json or application/xml*/
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getJsonDetails(@PathParam("empId") String empId) {
		Response response = null;
		try {
			
			
			EmpDetail empDetail = new EmpDetail();
			empDetail.setCity("New Delhi");
			empDetail.setCountry("India");
			
			Employee employee = new Employee();
			employee.setId(Integer.parseInt(empId));
			employee.setName("Imran Khan");
			employee.setEmpDetail(empDetail);
			
			response = Response.status(Status.OK).entity(employee).build();
		} catch(Exception e) {
			log.error(e);
			response = Response.status(Status.BAD_REQUEST).entity("Internal Sever Errror").build();
		}
		return response;
	}
}
