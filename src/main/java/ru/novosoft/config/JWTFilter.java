package ru.novosoft.config;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.novosoft.generators.Generator;
import ru.novosoft.model.Person;
import ru.novosoft.security.JWTUtil;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtil jwtUtil;
    private final Generator generator;

    @Autowired
    public JWTFilter(JWTUtil jwtUtil, Generator generator) {
        this.jwtUtil = jwtUtil;
        this.generator = generator;
    }

    @Override
    public void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = httpServletRequest.getHeader("Authorization");

        if (authHeader != null && !authHeader.trim().isEmpty() && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7);

            if (jwt.trim().isEmpty()) {
                httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid JWT Token in Bearer Header");
                return;
            }

            try {
                String username = jwtUtil.validateTokenAndRetrieveClaim(jwt);
                Person personDetails = generator.loadUserByUsername(username);

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(personDetails,
                                personDetails.getPassword());

                if (SecurityContextHolder.getContext().getAuthentication() == null) {
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (JWTVerificationException exc) {
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
                return;
            }
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    public String extractUsername(String authHeader) {
        if (authHeader != null && !authHeader.trim().isEmpty() && authHeader.startsWith("Bearer ")) {
            String jwt = authHeader.substring(7).trim();
            if (!jwt.isEmpty()) {
                try {
                    return jwtUtil.validateTokenAndRetrieveClaim(jwt);
                } catch (JWTVerificationException e) {
                    // Invalid token, return null
                }
            }
        }
        return null;
    }
}

