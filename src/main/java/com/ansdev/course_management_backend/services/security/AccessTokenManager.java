package com.ansdev.course_management_backend.services.security;

import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.properties.security.SecurityProperties;
import com.ansdev.course_management_backend.services.base.TokenGenerator;
import com.ansdev.course_management_backend.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
@RequiredArgsConstructor
public class AccessTokenManager implements TokenGenerator<User> {

    private final SecurityProperties securityProperties;



    @Override
    public String generate(User obj) {
        Claims claims = Jwts.claims();
        claims.put("email", obj.getEmail());

        Date now = new Date();
        Date validity = new Date(now.getTime() + securityProperties.getJwt().getAccessTokenValidityTime());

        return Jwts.builder()
                .setSubject(String.valueOf(obj.getId()))
                .setIssuedAt(now)
                .setExpiration(validity)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }
}
