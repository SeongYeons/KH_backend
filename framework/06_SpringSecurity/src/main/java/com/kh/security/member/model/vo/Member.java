package com.kh.security.member.model.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Member implements UserDetails {
	
	private static final long serialVersionUID = -4376331380920772259L;

	private int no;

	@NonNull
	private String id;

	@NonNull
	private String password;

	private String role;

	@NonNull
	private String name;

	private String phone;

	private String email;

	private String address;

	private String hobby;

	private String status;

	private Date enrollDate;

	private Date modifyDate;

	@Override
	public String getUsername() {

		return this.id;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	
	// 계정의 권한의 목록을 리턴한다.
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority(this.role));
		
		return authorities;
	}

	@Override
	// 계정 만료 여부
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	// 계정 잠김 여부
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	// 패스워드 만료 여부
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	// 계정 활성 여부
	public boolean isEnabled() {
		
		return this.status.equals("Y");
	}
}