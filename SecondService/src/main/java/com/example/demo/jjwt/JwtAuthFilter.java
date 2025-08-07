package com.example.demo.jjwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/actuator");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Missing or invalid Authorization header");
            return;
        }

        String token = authHeader.substring(7);

        if (token.isEmpty()) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Invalid JWT token");
            return;
        }

        // Optional: you can validate the token here
        // boolean valid = validateToken(token);
        // if (!valid) {
        //     response.setStatus(HttpStatus.UNAUTHORIZED.value());
        //     response.getWriter().write("JWT validation failed");
        //     return;
        // }

        filterChain.doFilter(request, response);
    }
}
