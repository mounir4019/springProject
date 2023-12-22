package com.example.springProject.config;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
 
import org.springframework.stereotype.Service;

import com.example.springProject.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 com.example.springProject.entity.User user = userService.getUserByIdUniq(username);
		System.out.println("user.getRole()");System.out.println(user.getRole());
		return new User(user.getIdUniq(), user.getPassword(), getGrantedAuthorities(user.getRole()));
	}

		private List<GrantedAuthority> getGrantedAuthorities(String role) { 
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       //authorities.add(new SimpleGrantedAuthority( /*  "ROLE_" + */  role)); 
       // String role est une StringTokenizer : tous les privilèe separé par des espaces 
       StringTokenizer st = new StringTokenizer(role);
            while (st.hasMoreTokens()) {  
                 authorities.add(new SimpleGrantedAuthority(   /*  "ROLE_" +    */ st.nextToken())); 
            }
            System.out.println("authorities");System.out.println(authorities);
		return authorities;
	}
}