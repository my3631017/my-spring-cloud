package com.service.provider.config;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2018-12-06 16:00
 */
//@Component
@WebFilter(filterName = "httpServletRequestWrapperFilter", urlPatterns = "/*")
@Slf4j
public class BodyReaderRequestFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        BodyReaderRequestWrapper requestWrapper = new BodyReaderRequestWrapper((HttpServletRequest) request);
        filterChain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {

    }
}
