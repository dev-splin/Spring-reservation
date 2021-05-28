package kr.or.connect.reservation.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	private String username;
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private Collection<? extends GrantedAuthority>authorities ;
	
    
    public void setUsername(String username) {
    	this.username = username;
    }
    @Override
    public String getUsername() {
    	return username;
    }
    
    
    public void setPassword(String password) {
    	this.password = password;
    }
    @Override
    public String getPassword() {
    	return password;
    }
    
    
    public void setEnabled(boolean isEnabled) {
    	this.isEnabled = isEnabled;
    }
    @Override
    public boolean isEnabled() {
    	return isEnabled;
    }
    
    
    public void setAccountNonExpired(boolean isAccountNonExpired) {
    	this.isAccountNonExpired = isAccountNonExpired;
    }
    @Override
    public boolean isAccountNonExpired() {
    	return isAccountNonExpired;
    }
    

	public void setAccountNonLocked(boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}
	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}
	

	public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}
	
	
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
}
