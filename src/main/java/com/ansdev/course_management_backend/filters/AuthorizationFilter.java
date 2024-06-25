package com.ansdev.course_management_backend.filters;

import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.services.security.AccessTokenManager;
import com.ansdev.course_management_backend.services.user.UserService;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {

    private final AccessTokenManager accessTokenManager;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");


        if (Objects.nonNull(token) && token.startsWith("Bearer ")) {
            final String AccesToken = token.substring(7);
            Claims claims= accessTokenManager.read(AccesToken);
            String email = claims.get("email", String.class);

         UserDetails user = userDetailsService.loadUserByUsername(email);

            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user, "", user.getAuthorities()    ));
        }

        System.out.println(token);


        filterChain.doFilter(request, response);




    }
}
