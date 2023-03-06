/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sextob.progrmacion.entidades.Usuario;
import com.sextob.progrmacion.servicios.UserDetailsImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 *
 * @author Bryan
 */
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

        Usuario user = new Usuario();

        try {
            user = new ObjectMapper().readValue(request.getReader(), Usuario.class);
        } catch (IOException e) {
        }
        
        UsernamePasswordAuthenticationToken usernamePat = UsernamePasswordAuthenticationToken.authenticated(
                user.getUsername(),
                user.getPassword(),
                Collections.emptyList()
        );

        return getAuthenticationManager().authenticate(usernamePat);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {
        
      UserDetailsImpl userDetailsImpl =  (UserDetailsImpl)authResult.getPrincipal();
        
      String token = TokenUtils.createToken(userDetailsImpl.getUsername());
      
      response.addHeader("Authorization", "Bearer " + token);
      response.getWriter().flush();
      
        super.successfulAuthentication(request, response, chain, authResult); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
