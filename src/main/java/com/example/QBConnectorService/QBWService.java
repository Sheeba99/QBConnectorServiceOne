package com.example.QBConnectorService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface QBWService {

    @WebMethod
    String checkCompanyFile();

    @WebMethod
    String[] authenticate(@WebParam(name = "strUserName") String username,
                          @WebParam(name = "strPassword") String password);

    @WebMethod
    String sendRequestXML(@WebParam(name = "ticket") String ticket,
                          @WebParam(name = "strCompanyFileName") String companyFileName,
                          @WebParam(name = "qbXMLCountry") String qbXMLCountry,
                          @WebParam(name = "qbXMLMajorVers") int qbXMLMajorVers,
                          @WebParam(name = "qbXMLMinorVers") int qbXMLMinorVers);

    @WebMethod
    int receiveResponseXML(@WebParam(name = "ticket") String ticket,
                           @WebParam(name = "response") String response,
                           @WebParam(name = "hresult") String hresult,
                           @WebParam(name = "message") String message);

    @WebMethod
    String connectionError(@WebParam(name = "ticket") String ticket,
                           @WebParam(name = "hresult") String hresult,
                           @WebParam(name = "message") String message);

    @WebMethod
    String closeConnection(@WebParam(name = "ticket") String ticket);
}
