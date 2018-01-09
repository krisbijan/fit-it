package com.krisbijan.fitit.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.krisbijan.fitit.model.Appuser;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		Appuser user = userRepository.findByName(arg0);
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), user.getRoles());
	}

}
