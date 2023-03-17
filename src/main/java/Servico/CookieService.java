package Servico;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieService {
    public static void setCookie(HttpServletResponse response , String key, String value, int segundos) {

        Cookie cookie = new Cookie("usuario", "logado");
        cookie.setMaxAge(segundos);
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request , String key){
        return Optional.ofNullable(request.getCookies()).flatMap(cookies -> Arrays.stream(cookies).filter(cookie -> cookie.getName().equals(key)).findFirst()).map(Cookie::getValue).orElse(null);

    }
}
