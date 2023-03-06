/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sextob.progrmacion.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

/**
 *
 * @author Bryan
 */
public class TokenUtils {

    private final static String ACCESS_TOKEN = "XTZuUNbEQk?jCNFjzc7E-br!82Q!5dUjytETNHcHQj";

    private final static Long ACCESS_TOKEN_VALIDATE_TIME = 86_400L;

    public static String createToken(String username) {
        long expirationTime = ACCESS_TOKEN_VALIDATE_TIME * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("username", username);

        return Jwts.builder()
                .setSubject(username)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {

        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String unsername = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(unsername, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }

    }
}
