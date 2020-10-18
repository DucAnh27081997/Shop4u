package com.shop4u.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop4u.Model.UserDTO;
import com.shop4u.service.UserService;

@RestController
@RequestMapping("/api")
public class RestUserController {

	@Autowired
	UserService UserService;

	@RequestMapping(value = "/User", method = RequestMethod.GET)
	@ResponseBody
	public List<UserDTO> getAllUser() {
		List<UserDTO> lstUser = UserService.getAllUser();
		return lstUser;
	}

	@RequestMapping(value = "/User/{id}", method = RequestMethod.GET)
	@ResponseBody
	public UserDTO getUserById(@PathVariable("id") int id) {
		UserDTO User = UserService.getUserById(id);
		if (User != null)
			return User;
		else
			return null;
	}

	@RequestMapping(value = "/User/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String DeleteUserById(@PathVariable("id") int id) {
		UserDTO User = UserService.getUserById(id);
		if (User != null) {
			UserService.deleteUser(id);
			return "success";
		} else
			return "fail";
	}

	@RequestMapping(value = "/User", method = RequestMethod.POST)
	@ResponseBody
	public String AddUser(@RequestBody UserDTO User) {
		try {
			UserService.addUser(User);
			return "success";
		} catch (Exception e) {
			return "fail: " + e.getMessage();
		}
	}

	@RequestMapping(value = "/User", method = RequestMethod.PUT)
	@ResponseBody
	public String UpdateUser(@RequestBody UserDTO User) {
		try {
			if (UserService.getUserById(User.getId()) != null) {
				UserService.updateUser(User);
				return "success";
			} else {
				return "fail: ko ton tai!";
			}
		} catch (Exception e) {
			return "fail: " + e.getMessage();
		}
	}

}
