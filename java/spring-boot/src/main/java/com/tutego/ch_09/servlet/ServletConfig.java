package com.tutego.ch_09.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

    @Bean // registers a servlet that handles requests under /stat
    // ServletRegistrationBean registers the servlet directly with the servlet container, DispatcherServlet is not involved here
    public ServletRegistrationBean<StatisticServlet> statServlet() {
        return new ServletRegistrationBean<>(new StatisticServlet(), "/stat");
    }

}
