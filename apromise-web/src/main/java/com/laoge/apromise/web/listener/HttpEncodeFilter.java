package com.laoge.apromise.web.listener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * filter 过滤器 设置 过滤器  WebFilter ,WebServlet,WebListener 通过 ServletComponentScan 配置扫描路径
 * Created by yuhou on 2017/5/11.
 */
@WebFilter
public class HttpEncodeFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(HttpEncodeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("HttpEncodeFilter init ");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("HttpEncodeFilter doFilter ");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

        logger.info("HttpEncodeFilter destroy ");

    }
}
