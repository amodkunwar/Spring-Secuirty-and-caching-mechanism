package com.amod.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.amod.security.config.UserInforUserDetials;
import com.amod.security.entity.UserInfo;
import com.amod.security.repository.UserRepository;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfo> userDetailsOptional = userRepository.findByName(username);
		return userDetailsOptional.map(UserInforUserDetials::new)
				.orElseThrow(() -> new UsernameNotFoundException("user name not found " + username));
	}

}
