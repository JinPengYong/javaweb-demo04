package com.cheer.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/*",initParams = @WebInitParam(name="ignoreURI",
        value ="login.html;servlet/LoginServlet"))
public class LoginFilter implements Filter {
    private String[] ignoreURI;
    
    
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpServletResponse response=(HttpServletResponse) resp;
        String uri = request.getRequestURI();
        if(!ignoreRequest(uri)){
            HttpSession session=request.getSession();
            Object username = session.getAttribute("username");
            if(username==null){
                response.sendRedirect(request.getContextPath()+"/login.html");
                return;
            }
        }


        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        String value=config.getInitParameter("ignoreURI");
        ignoreURI = value.split(";");

    }

    public boolean ignoreRequest(String uri){
        for (String s : ignoreURI) {
            if(uri.endsWith(s)){
                return true;
            }
        }
        return false;
    }

}
