package com.shop4u.Model;

public class UserDTO {
	private int id;

	private String about;

	private String email;

	private boolean enable;

	private String favourites;

	private String gender;

	private String password;

	private String role;

	private String username;

	public UserDTO() {
		
	}
	public UserDTO(int id, String about, String email, boolean enable, String favourites, String gender, String password,
			String role, String username) {
		this.id = id;
		this.about = about;
		this.email = email;
		this.enable = enable;
		this.favourites = favourites;
		this.gender = gender;
		this.password = password;
		this.role = role;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public String getFavourites() {
		return favourites;
	}

	public void setFavourites(String favourites) {
		this.favourites = favourites;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
