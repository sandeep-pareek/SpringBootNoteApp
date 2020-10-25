package com.sandeep.SpringBootNoteApp.filter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.sandeep.SpringBootNoteApp.service.JSONWebTokenService;
import com.sandeep.SpringBootNoteApp.service.CustomUserDetailsService;

/**
 *
 * @author sandeep
 * @since 25th Oct 2020
 */

@Component
public class JSONWebTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JSONWebTokenService jSONWebTokenService;
	@Autowired
	private CustomUserDetailsService service;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) {

		String authorizationHeader = httpServletRequest.getHeader("Authorization");

		String token = null;
		String userName = null;

		try {

			if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
				token = authorizationHeader.substring(7);
				userName = jSONWebTokenService.extractUsername(token);
			}

			if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UserDetails userDetails = service.loadUserByUsername(userName);

				if (jSONWebTokenService.validateToken(token, userDetails)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetails, null, userDetails.getAuthorities());
					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
			}

			filterChain.doFilter(httpServletRequest, httpServletResponse);
		} catch (Exception e) {
			System.out.println("### Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
