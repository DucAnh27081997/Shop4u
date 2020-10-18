package com.shop4u.service;
import com.shop4u.Model.UserDTO;

public interface UserService {
	public void addUser(UserDTO x);

	public void updateUser(UserDTO x);

	public void deleteUser(int id);

	public UserDTO getUserById(int id);

	public java.util.List<UserDTO> getAllUser();
}
