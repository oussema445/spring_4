package com.oussema.pieces.service;



import com.oussema.pieces.entities.Role;
import com.oussema.pieces.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);


}

