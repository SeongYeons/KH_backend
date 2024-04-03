package com.kh.security.handler;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
	
		List<String> roleNames = authentication.getAuthorities()
								  .stream()
								  .map(GrantedAuthority::getAuthority)
								  .collect(Collectors.toList());
		
		if (roleNames.contains("ROLE_ADMIN")) {			
			response.sendRedirect(request.getContextPath() + "/admin/view");
		} else {			
			response.sendRedirect(request.getContextPath() + "/");
		}
	}
}
