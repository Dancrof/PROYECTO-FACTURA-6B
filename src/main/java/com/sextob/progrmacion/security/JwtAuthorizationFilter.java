/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 *
 * @author Bryan
 */
@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request,
            HttpServletResponse response, 
            FilterChain filterChain) throws ServletException, IOException {
        
        String bearerToken = request.getHeader("Authorization");
        
        if(bearerToken != null && bearerToken.startsWith("Bearer ")){
        
            String token = bearerToken.replace("Bearer ", "");
            UsernamePasswordAuthenticationToken usernamePat = TokenUtils.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(usernamePat);
        }
        
        filterChain.doFilter(request, response);
    }
    
    
}
