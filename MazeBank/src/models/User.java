package models;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int id;
	private String username;
	private String email;
	private String password;
	private String phone;
	private float money;
	private List<Contact> contacts;
	
	public User() {
		
	}

	public User(String username, String email, String password, String phone) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.money = 0.0F;
		this.contacts = new ArrayList<>();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password + ", phone="
				+ phone + ", money=" + money + "]";
	}
	
	

}
