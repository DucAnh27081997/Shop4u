package com.shop4u.dao;
import com.shop4u.entity.User;

public interface UserDAO {
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public User getUserById(int id);
	public java.util.List<User> getAllUser();
}
