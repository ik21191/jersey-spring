package mypack.beans;

class Message {
	
	String code, name;

	
	public Message(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	
	public Message() {
	
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}