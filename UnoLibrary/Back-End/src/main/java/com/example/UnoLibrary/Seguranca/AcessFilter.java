package com.example.UnoLibrary.Seguranca;

import java.io.IOException;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AcessFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String token = req.getHeader("Authorization");

        if (token != null && JWTTokenProvider.verifyToken(token)) {
            String nivelAcesso = JWTTokenProvider.getNivelAcessoFromToken(token);

            if ("admin".equals(nivelAcesso) || "func".equals(nivelAcesso)) {
                chain.doFilter(request, response);
            }
            else {
                res.setStatus(HttpServletResponse.SC_FORBIDDEN);
                res.getWriter().write("Acesso não autorizado");
            }
        }
        else {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("Não autorizado");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}


