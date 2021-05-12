package com.demo.springmvc.configuration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class MyUrlAuthSuccessHandler implements AuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		handle(request,response,authentication);
		clear(request);
		
	}

	private void clear(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session==null) {
			return;
			
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);		
	}

	private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
		String targetUrl=detemineUrlOnRole(authentication);//own method
		if(response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	private String detemineUrlOnRole(Authentication authentication) {
		
		boolean isUser=false;
		boolean isVendor=false;
		boolean isPatient=false;
		boolean isAdmin=false;
		for(GrantedAuthority authority:authentication.getAuthorities()) {
		//authentication.getAuthorities();//returns collection of granted authorities
			
			if(authority.getAuthority().equals("ROLE_ADMIN")) {
				isAdmin=true;
				break;
			}else if(authority.getAuthority().equals("ROLE_VENDOR")) {
				isVendor=true;
				break;
			}
			else if(authority.getAuthority().equals("ROLE_PATIENT")) {
				isPatient=true;
				break;
			}else if(authority.getAuthority().equals("ROLE_USER")) {
				isUser=true;
				break;
			}
				
		}
		if(isUser) {
			return "/user";
					}
		else if(isAdmin){
			return "/admin";
					
		}
		else if(isVendor) {
			return "/vendor";
		}
		else if(isPatient) {
			return"/patient";
		}
		else
			throw new IllegalStateException("Unknown Role Here");
	}

}
