package com.example.QBConnectorService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface QBWService {

    @WebMethod
    String checkCompanyFile();
}
