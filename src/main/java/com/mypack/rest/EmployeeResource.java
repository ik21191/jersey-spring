package com.mypack.rest;

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
import com.mypack.exception.MyException;


@Path("/employee")
public class EmployeeResource {
	private static final Logger log = Logger.getLogger(EmployeeResource.class);
	
	@POST
	@Path("/detail/{empId}")
	/**This method will produce both xml and json response. In browser we need to set header as Accept: application/json or application/xml*/
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getJsonDetails(@PathParam("empId") int empId) throws MyException {
		Response response = null;
		try {
			EmpDetail empDetail = new EmpDetail();
			empDetail.setCity("New Delhi");
			empDetail.setCountry("India");
			
			Employee employee = new Employee();
			employee.setId(empId);
			employee.setName("Imran Khan");
			employee.setEmpDetail(empDetail);
			
			response = Response.status(Status.OK).entity(employee).build();
			if(empId == 100) {
				throw new MyException(400, "Custom NullPointerException", new NullPointerException());
			} else if(empId == 101) {
				throw new MyException(400, "Custom ArrayIndexOutOfBoundsException", new NullPointerException());
			} else if(empId == 102) {
				throw new MyException(400, "Custom FileNotFoundException", new NullPointerException());
			}
			
		} catch(Exception e) {
			log.error(e);
		}
		return response;
	}
}
