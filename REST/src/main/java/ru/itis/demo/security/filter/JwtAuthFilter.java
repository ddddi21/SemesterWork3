package ru.itis.demo.security.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.itis.demo.security.auth.JwtAuth;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component( "jwtAuthenticationFilter")
public class JwtAuthFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // преобразуем запрос в HTTP
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        // получаем токен
        String token = request.getHeader("Authorization");
        // создаем объект аутентификации
        Authentication authentication = new JwtAuth(token);
        // кладем его в контекст для текущего потока
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // отправили запрос дальше
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
