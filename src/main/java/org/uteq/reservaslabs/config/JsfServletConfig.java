package org.uteq.reservaslabs.config;

import jakarta.faces.webapp.FacesServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsfServletConfig {

    @Bean
    public ServletRegistrationBean<FacesServlet> facesServlet() {
        ServletRegistrationBean<FacesServlet> servlet =
                new ServletRegistrationBean<>(new FacesServlet(), "/faces/*");
        servlet.setLoadOnStartup(1);
        return servlet;
    }
}

