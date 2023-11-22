package com.example.UnoLibrary.Seguranca;

import java.io.IOException;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AcessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Authorization");

        if (token != null && JWTTokenProvider.verifyToken(token)) {
            String nivelAcesso = JWTTokenProvider.getNivelAcessoFromToken(token);

            if ("admin".equals(nivelAcesso) || "func".equals(nivelAcesso)) {
                chain.doFilter(request, response);
            }
            else {
                ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_FORBIDDEN);
                response.getOutputStream().write("Acesso não autorizado".getBytes());
            }
        }
        else {
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getOutputStream().write("Não autorizado".getBytes());
        }
    }
}


