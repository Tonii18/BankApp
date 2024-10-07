package models;

public class Contact {
	
	private int id;
	private String username;
	private String email;
	private String phone;
	
	public Contact() {
		
	}

	public Contact(int id, String username, String email, String phone) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public String toString() {
		return "Contact [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + "]";
	}
	
	

}
