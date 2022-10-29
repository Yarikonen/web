package filters;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class AuthFilter implements Filter {
    FilterConfig filterConfig;
    private  String authParam;
    public void init(FilterConfig config) throws ServletException {
        this.filterConfig=config;
        authParam =(filterConfig.getInitParameter("authParam"));
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req= (HttpServletRequest) request;
        String secret = req.getHeader("Authorization");
        if (authParam.equals(secret)) {
                chain.doFilter(request, response);
        } else {
                ((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, secret );
        }






}}
