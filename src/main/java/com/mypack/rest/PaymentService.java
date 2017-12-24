package com.mypack.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mypack.transaction.TransactionBo;

import mypack.beans.Address;
import mypack.beans.Product;

@Component
@Path("/payment")
public class PaymentService {
	
	private static Logger log = Logger.getLogger(PaymentService.class); 

	@Autowired
	TransactionBo transactionBo;

	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePayment() {

		String result = transactionBo.save();

		return Response.status(200).entity(result).build();

	}

	@GET
	@Path("/product")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductInJSON() {
		log.info("getProductInJSON() is called.");
		Address address = new Address();
		address.setCity("New Delhi");
		Product product = new Product();
		product.setName("iPad 3");
		product.setQty(999);
		product.setAddress(address);
		return product;
	}

}