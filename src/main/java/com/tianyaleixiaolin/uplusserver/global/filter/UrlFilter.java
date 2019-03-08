package com.tianyaleixiaolin.uplusserver.global.filter;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 加统一的前缀
 *
 * @author Mr.li wrote on 2018/11/1.
 */
public class UrlFilter implements Filter {

    @Override
    public void destroy() {
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
            ServletException {
        //HttpServletRequest httpRequest = (HttpServletRequest) request;
        ParameterRequestWrapper httpRequest = new ParameterRequestWrapper(
                (HttpServletRequest) request);
        String path = httpRequest.getRequestURI();
        httpRequest.getRequestDispatcher(path).forward(httpRequest, response);
    }
}