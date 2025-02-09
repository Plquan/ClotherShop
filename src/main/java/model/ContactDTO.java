package model;

public class ContactDTO {
	public int id;
	public String name;
	public String email;
	public String phone;
	public String message;
	public String status;

	public ContactDTO() {

	}

	public ContactDTO(int id, String name, String email, String phone, String message, String status) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.message = message;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
