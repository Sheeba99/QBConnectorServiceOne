package com.example.QBConnectorService;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SoapServiceConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(SoapServiceConfiguration.class);

    private final Bus bus;
    private final QBWServiceImpl userSoapService;

    public SoapServiceConfiguration(Bus bus, QBWServiceImpl userSoapService) {
        this.bus = bus;
        this.userSoapService = userSoapService;
    }
    @Bean
    public EndpointImpl userSoapEndpoint() { // Use EndpointImpl as return type
        EndpointImpl endpoint = new EndpointImpl(bus, userSoapService);
        endpoint.publish("/qbwService");
        Map<String, Object> properties = new HashMap<>();
        properties.put("endpoint-name", "QBWService");
        properties.put("service-name", "{http://QBConnectorService.example.com/}QBWService");
        properties.put("wsdl.service", "{http://QBConnectorService.example.com/}QBWServiceImplService");
        properties.put("wsdl.port", "{http://QBConnectorService.example.com/}QBWServiceImplPort");
        endpoint.setProperties(properties);
        return endpoint;
    }
}
