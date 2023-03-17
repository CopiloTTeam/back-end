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

    public static String getCookie(HttpServletRequest request ){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            Optional<Cookie> cookie = Arrays.stream(cookies).filter(c -> c.getName().equals("usuario")).findFirst();
            if(cookie.isPresent()){
                return cookie.get().getValue();
            }
        }
        return null;    


    }
}
