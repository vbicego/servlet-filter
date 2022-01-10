package de.evoila.servletfilter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class SimpleFilter implements Filter {

    private final AtomicLong counter = new AtomicLong();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

//        System.out.println("Remote Host:" + servletRequest.getRemoteHost());
//        System.out.println("Remote Address:" + servletRequest.getRemoteAddr());

        if (counter.incrementAndGet() % 2 == 0) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("Access denied, try again");
        }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
