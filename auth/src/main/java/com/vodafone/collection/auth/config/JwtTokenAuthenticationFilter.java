package com.vodafone.collection.auth.config;


import com.vodafone.collection.auth.constants.AuthConstant;
import com.vodafone.collection.auth.service.ConfigurationEntityService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {
//	@Autowired
//	ConfigurationEntityService configurationEntityService;
//	
	private ConfigurationEntityService configurationEntityService;

	@Autowired
	public JwtTokenAuthenticationFilter(ConfigurationEntityService configurationEntityService) {
		this.configurationEntityService = configurationEntityService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
//		ConfigurationEntityService configurationEntityService = new ConfigurationEntityService();
		String secretJWTKey = configurationEntityService.getByKey(AuthConstant.JWT_SECRET_KEY).getValue();

		// 1. get the authentication header. Tokens are supposed to be passed in the
		// authentication header
		String header = request.getHeader("Authorization");
		
		// 2. validate the header and check the prefix
		if (header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(request, response); // If not valid, go to the next filter.
			return;
		}

		// 3. Get the token
		String token = header.replace("Bearer ", "");

		try {

			// 4. Validate the token
			Claims claims = Jwts.parser().setSigningKey(secretJWTKey.getBytes()).parseClaimsJws(token).getBody();

			String username = claims.getSubject();
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				//UsernamePasswordAuthenticationToken auth = null;
				//@SuppressWarnings("unchecked")
				//List<String> authorities = (List<String>) claims.get("authorities");

				//if (authorities != null) {
					//auth = new UsernamePasswordAuthenticationToken(username, null,

						//	authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
			//	} else {
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, null);

				//}

				SecurityContextHolder.getContext().setAuthentication(auth);

			}

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ExpiredJwtException e) {
			request.setAttribute("expired", "JWT expired");

		} catch (Exception e) {
			// In case of failure. Make sure it's clear; so guarantee user won't be
			// authenticated
			SecurityContextHolder.clearContext();
		}

		// go to the next filter in the filter chain
		chain.doFilter(request, response);
	}

}
