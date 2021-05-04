package ru.itis.demo.helpers;

import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;
import ru.itis.demo.dto.SignInFormDto;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//TODO(potom)

@Component
public class CookieHelper {
    public void addCookie(SignInFormDto form, HttpServletResponse response, String cookiesName){
        Cookie cookie = new Cookie(cookiesName, form.getEmail());
        cookie.setMaxAge(-1);
        //addCookie
        response.addCookie(cookie);
    }

    public Boolean checkCookie(HttpServletRequest request, String cookiesName){
        Cookie checkCookie = WebUtils.getCookie(request, cookiesName);
        return checkCookie != null;
    }
}
