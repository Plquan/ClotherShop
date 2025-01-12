
package model;


public class UserDTO {
    private int id;
    private String email;
    private String avatar;
    private String userName;
    private String password;
    private String address;
    private String phone;
    private String role;
    private String status;

    public UserDTO() {
    }

    public UserDTO(int id, String email, String avatar, String userName, String password, String address, String phone, String role, String status) {
        this.id = id;
        this.email = email;
        this.avatar = avatar;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.status = status;
        this.address = address;
        this.phone = phone;
    }

    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Username: " + userName + ", Email: " + email + ", Phone: " + phone;
    }
    
}














