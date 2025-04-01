package com.example.QBConnectorService;

import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfServletConfiguration {

    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        // Map the CXF servlet to handle requests at "/services/*"
        return new ServletRegistrationBean<>(new CXFServlet(), "/*");
    }
}
