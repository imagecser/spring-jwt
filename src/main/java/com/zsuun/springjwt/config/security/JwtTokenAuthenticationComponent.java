package com.zsuun.springjwt.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenAuthenticationComponent {

    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 2; // 2 hours
    private static final String SECRET = "SPR1NG_T0KEN_PREF1X";
    private static final String TOKEN_PREFIX = "Jwt";
    private static final String HEADER_KEY_NAME = "Authorization";

    static void addAuthentication(HttpServletResponse response, String username) {
        String jwt = Jwts.builder()
                .claim("authorities", "ROLE_USER")
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        try {
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().println(jwt);
        } catch (IOException ignore) {
        }
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_KEY_NAME);
        if (null != token) {
            Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            String username = claims.getSubject();
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(claims.get("authorities").toString());
            return null == username ?
                    null :
                    new UsernamePasswordAuthenticationToken(username, null, authorities);
        }
        return null;
    }
}
