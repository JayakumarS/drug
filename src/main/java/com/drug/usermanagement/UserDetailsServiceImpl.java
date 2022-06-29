package com.drug.usermanagement;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drug.employeeMaster.EmployeeMasterService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private EmployeeMasterService employeeMasterService;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			 user = employeeMasterService.getEmployeeUserName(username)
					.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return UserDetailsImpl.build(user);
	}

}
