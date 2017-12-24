package mypack.beans;

import javax.validation.constraints.Size;


public class Product {

	@Size(min=5,max=255, message = "Value should be greater than 5")
	String name;
	int qty;
	Address address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", qty=" + qty + "," + address.getCity() + "]";
	}

}