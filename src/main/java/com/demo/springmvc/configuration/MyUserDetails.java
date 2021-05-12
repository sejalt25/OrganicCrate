package com.demo.springmvc.configuration;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.demo.springmvc.bean.User;

public class MyUserDetails extends User implements UserDetails {
	private static final long serialVersionUID = 329472637081575721L;
    
	private User user;
	
	public MyUserDetails(final User user) {
		super(user.getUserId(),user.getEmail(),user.getPassword(),user.getFirstName(),user.getLastName(),user.isEnabled(),user.getDob(),user.getGender(),user.getUserMobile(),user.getRoles(),user.getAddress());
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRoleName())).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return super.isEnabled();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.isEnabled();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return  super.isEnabled();
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return  super.isEnabled();
	}
	
	public String getFullName() {
        return user.getFirstName() + " " + user.getLastName();
    }

}
