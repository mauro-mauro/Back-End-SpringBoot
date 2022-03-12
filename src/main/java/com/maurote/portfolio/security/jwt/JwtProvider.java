package com.maurote.portfolio.security.jwt;

// import com.nimbusds.jwt.JWT;
// import com.nimbusds.jwt.JWTClaimsSet;
// import com.nimbusds.jwt.JWTParser;
import com.maurote.portfolio.security.dto.JwtDto;
import com.maurote.portfolio.security.entity.UsuarioPrincipal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.*;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


//Genera token 
//Posee un metodo de validacion para comprobar que este bien formado ni expirado etc
@Component
public class JwtProvider {
    private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    // Se encuentran en el archivo propiedades
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication) {
        UsuarioPrincipal usuarioPrincipal = (UsuarioPrincipal) authentication.getPrincipal();
        List<String> roles = usuarioPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList());
        return Jwts.builder()
                .setSubject(usuarioPrincipal.getUsername())
                .claim("roles", roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes())
                .compact();
    }

    public String getNombreUsuarioFromToken(String token) {
        return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException e) {
            logger.error("token mal formado");
        } catch (UnsupportedJwtException e) {
            logger.error("token no soportado");
        } catch (ExpiredJwtException e) {
            logger.error("token expirado");
        } catch (IllegalArgumentException e) {
            logger.error("token vacio");
        } catch (SignatureException e) {
            logger.error("fail en la firma");
        }
        return false;
    }


    // public String refreshToken(JwtDto jwtDto) throws ParseException {
    //     JWT jwt = JWTParser.parse(jwtDto.getToken());
    //     JWTClaimsSet claims=jwt.getJWTClaimsSet();
    //     String nombreUsuario=claims.getSubject();
    //     List<String> roles = (List<String>) claims.getClaim("roles");

    //     return Jwts.builder()
    //             .setSubject(nombreUsuario)
    //             .claim("roles", roles)
    //             .setIssuedAt(new Date())
    //             .setExpiration(new Date(new Date().getTime() + expiration))
    //             .signWith(SignatureAlgorithm.HS512, secret.getBytes())
    //             .compact();
    // }
}
