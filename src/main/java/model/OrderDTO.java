package model;

import java.sql.Date;

public class OrderDTO {
	public int id;
	public String code;
	public String userName;
	public String email;
	public String phone;
	public String address;
	public String note;
	public Double totalPrice;
	public Date createdAt;
	public String paymentMethod;
	public String paymentStatus;
	public String status;
	
	
	public OrderDTO() {
	
	}
	public OrderDTO(int id, String code, String userName, String email, String phone, String address, String note,
			Double totalPrice, Date createdAt, String paymentMethod, String paymentStatus, String status) {
		this.id = id;
		this.code = code;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.note = note;
		this.totalPrice = totalPrice;
		this.createdAt = createdAt;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}




