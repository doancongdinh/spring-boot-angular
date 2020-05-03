package com.javainuse.service;

import java.util.ArrayList;

import com.javainuse.dao.UserDao;
import com.javainuse.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO user = userDao.findUser(username);
		if (user != null) {
			return new User(user.getUserName(), user.getPassWord(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}

	public int save(UserDTO user) {
		UserDTO newUser = new UserDTO();
		newUser.setUserName(user.getUserName());
		newUser.setPassWord(bcryptEncoder.encode(user.getPassWord()));
		return userDao.save(newUser);
	}

}
