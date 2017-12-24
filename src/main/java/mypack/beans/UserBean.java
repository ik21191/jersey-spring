package mypack.beans;

import java.util.ArrayList;
import java.util.List;

public class UserBean {

	private String name, city;
	private int roll;
	
	List<Message> list;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public List<Message> getList() {
		Message m1 = new Message("code1", "message1");
		Message m2 = new Message("code2", "message2");
		Message m3 = new Message("code3", "message3");
		List<Message> myList = new ArrayList<Message>();
		myList.add(m1);
		myList.add(m2);
		myList.add(m3);
		return list;
	}
	public void setList(List<Message> list) {
		this.list = list;
	}
	
}
