package com.shop4u.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop4u.entity.User;
import com.shop4u.Model.UserDTO;
import com.shop4u.dao.UserDAO;
import com.shop4u.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO UserDAO;

	@Override
	public void addUser(UserDTO x) {
		User User = new User();

		User.setId(x.getId());
		User.setUsername(x.getUsername());
		User.setEmail(x.getEmail());
		User.setFavourites(x.getFavourites());
		User.setPassword(x.getPassword());
		User.setEnable(x.getEnable());
		User.setRole(x.getRole());
		User.setAbout(x.getAbout());
		User.setGender(x.getGender());

		UserDAO.addUser(User);
	}

	@Override
	public void updateUser(UserDTO x) {
		User User = new User();

		User.setId(x.getId());
		User.setUsername(x.getUsername());
		User.setEmail(x.getEmail());
		User.setFavourites(x.getFavourites());
		User.setPassword(x.getPassword());
		User.setEnable(x.getEnable());
		User.setRole(x.getRole());
		User.setAbout(x.getAbout());
		User.setGender(x.getGender());

		UserDAO.updateUser(User);
	}

	@Override
	public void deleteUser(int id) {
		UserDAO.deleteUser(id);
	}

	@Override
	public UserDTO getUserById(int id) {

		User User = UserDAO.getUserById(id);
		if (User != null) {
			UserDTO x = new UserDTO();
			
			x.setId(User.getId());
			x.setUsername(User.getUsername());
			x.setEmail(User.getEmail());
			x.setFavourites(User.getFavourites());
			x.setPassword(User.getPassword());
			x.setEnable(User.getEnable());
			x.setRole(User.getRole());
			x.setAbout(User.getAbout());
			x.setGender(User.getGender());
			
			return x;
		}
		return null;
	}

	@Override
	public List<UserDTO> getAllUser() {
		List<User> lst = UserDAO.getAllUser();
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (User item : lst) {

			UserDTO x = new UserDTO();
			
			x.setId(item.getId());
			x.setUsername(item.getUsername());
			x.setEmail(item.getEmail());
			x.setFavourites(item.getFavourites());
			x.setPassword(item.getPassword());
			x.setEnable(item.getEnable());
			x.setRole(item.getRole());
			x.setAbout(item.getAbout());
			x.setGender(item.getGender());
			
			result.add(x);
		}
		return result;
	}

}
