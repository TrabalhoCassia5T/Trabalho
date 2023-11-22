package com.example.UnoLibrary.Seguranca;

import com.example.UnoLibrary.Model.entity.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class JWTTokenProvider {
    private static final SecretKey CHAVE = Keys.hmacShaKeyFor(
            "CHAVESECRETA123PROJETOBIBLIOTECA".getBytes(StandardCharsets.UTF_8));

    static public String getToken(Usuario usuario) {
        String jwtToken = Jwts.builder()
                .setSubject(usuario.getUsu_login())
                .setIssuer("localhost:8080")
                .claim("id", usuario.getId())
                .claim("nivel", usuario.getUsu_nivel())
                .claim("funcionario", usuario.getFuncionario())
                .claim("data", formatDate(usuario.getUsu_data_perm()))
                .claim("data_desativacao", formatDate(usuario.getUsu_data_desativa()))
                .setIssuedAt(new Date())
                .setExpiration(Date.from(LocalDateTime.now().plusMinutes(15L)
                        .atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(CHAVE)
                .compact();
        return jwtToken;
    }

    private static String formatDate(LocalDate date) {
        return date != null ? date.toString() : null;
    }

    static public boolean verifyToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(CHAVE)
                    .build()
                    .parseClaimsJws(token).getSignature();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    static public Claims getAllClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(CHAVE)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println("Erro ao recuperar as informações (claims)");
        }
        return claims;
    }

    public static String getNivelAcessoFromToken(String token) {
        String nivel = null;
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(CHAVE)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            nivel = claims.get("nivel", String.class);
        } catch (Exception e) {
            System.out.println("Erro ao recuperar as informações (claims)");
        }

        return nivel;
    }
}
