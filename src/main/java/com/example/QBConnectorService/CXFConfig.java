package com.example.QBConnectorService;


import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.Bus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.xml.ws.Endpoint;

@Configuration
public class CXFConfig {

    private final QBWService qbwService;

    public CXFConfig(QBWService qbwService) {
        this.qbwService = qbwService;
    }

    @Bean
    public Endpoint endpoint(Bus bus) {
        EndpointImpl endpoint = new EndpointImpl(bus, qbwService);
        endpoint.publish("/qbwservice");
        return endpoint;
    }
}
