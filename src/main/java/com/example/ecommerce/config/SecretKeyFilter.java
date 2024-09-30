package com.example.ecommerce.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SecretKeyFilter extends HttpFilter {

    @Value("${app.secret-key}")
    private String secretKey ;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String requestSecretKey = request.getHeader("X-Secret-Key") ;
        System.out.println("debug1 " + requestSecretKey);
        System.out.println("debug2 " + secretKey );
        if (secretKey.equals(requestSecretKey)) {
            chain.doFilter(request, response);
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Forbidden : Invalid Secret key");
        }
    }
}
