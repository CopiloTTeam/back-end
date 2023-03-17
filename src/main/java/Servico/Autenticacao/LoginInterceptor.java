package Servico.Autenticacao;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI();
        if(uri.endsWith("/login") || uri.endsWith("/logar")){
            return true;
        }
        if(request.getSession().getAttribute("funcionarioLogado") != null){
            return true;
        }
        response.sendRedirect("/login");
        return false;
    }
}
