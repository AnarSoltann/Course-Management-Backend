package com.ansdev.course_management_backend.services.security;


import com.ansdev.course_management_backend.models.dto.RefreshTokenDto;
import com.ansdev.course_management_backend.models.mybatis.user.User;
import com.ansdev.course_management_backend.models.properties.security.SecurityProperties;
import com.ansdev.course_management_backend.services.base.TokenGenerator;
import com.ansdev.course_management_backend.services.base.TokenReader;
import com.ansdev.course_management_backend.services.getters.EmailGetter;
import com.ansdev.course_management_backend.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.ansdev.course_management_backend.constants.TokenConstants.EMAIL_KEY;

@Component
@Slf4j
@RequiredArgsConstructor
public class RefreshTokenManager implements TokenGenerator<RefreshTokenDto>, TokenReader<Claims>, EmailGetter {


    private final SecurityProperties securityProperties;

    @Override
    public String generate(RefreshTokenDto obj) {

        final User user = obj.getUser();

            Claims claims = Jwts.claims();
            claims.put("email", user.getEmail());
            claims.put("type", "REFRESH_TOKEN");

            Date now = new Date();
            Date validity = new Date(now.getTime() + securityProperties.getJwt()
                    .getRefreshTokenValidityTime(obj.isRememberMe()));

            return Jwts.builder()
                    .setSubject(String.valueOf(user.getId()))
                    .setIssuedAt(now)
                    .setExpiration(validity)
                    .addClaims(claims)
                    .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                    .compact();
        }

    @Override
    public Claims read(String token) {

        Claims tokenData = Jwts.parserBuilder()
                .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

        String typeOfToken = tokenData.get("type", String.class);


        if (!typeOfToken.equals("REFRESH_TOKEN")) {
            throw new RuntimeException("Invalid token type");
        }
        return tokenData;
    }

    @Override
    public String getEmail(String token) {
        return read(token).get(EMAIL_KEY, String.class);
    }
}
