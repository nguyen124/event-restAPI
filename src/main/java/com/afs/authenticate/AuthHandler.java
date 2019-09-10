package com.afs.authenticate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AuthHandler extends SimpleUrlAuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	protected String determineTargetUrl(Authentication auth, HttpServletRequest req, String user) {
		String url = "";
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority a : authorities) {
			roles.add(a.getAuthority());
		}
		req.setAttribute("role", "User");
		if (roles.contains("ROLE_ADMIN")) {
			url = "/?role=Administrator&user=" + user;
		} else if (roles.contains("ROLE_USER")) {
			url = "/?role=User&user=" + user;
		}
		return url;
	}

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException {
		String userName = "";
		User user = (User) auth.getPrincipal();
		if (user != null) {
			userName = user.getUsername();

		}
		String targetUrl = determineTargetUrl(auth, request, userName);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

}
