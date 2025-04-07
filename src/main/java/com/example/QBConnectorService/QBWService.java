package com.example.QBConnectorService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(
        targetNamespace = "",
        name = "QBWService"
)
public interface QBWService {

    @WebMethod
    String checkCompanyFile();

    @WebMethod
    String[] authenticate(@WebParam(name = "strUserName", targetNamespace = "") String username,
                          @WebParam(name = "strPassword", targetNamespace = "") String password);

    @WebMethod
    String sendRequestXML(@WebParam(name = "ticket") String ticket,
                          @WebParam(name = "strCompanyFileName", targetNamespace = "") String companyFileName,
                          @WebParam(name = "qbXMLCountry", targetNamespace = "") String qbXMLCountry,
                          @WebParam(name = "qbXMLMajorVers", targetNamespace = "") int qbXMLMajorVers,
                          @WebParam(name = "qbXMLMinorVers", targetNamespace = "") int qbXMLMinorVers);

    @WebMethod
    int receiveResponseXML(@WebParam(name = "ticket", targetNamespace = "") String ticket,
                           @WebParam(name = "response", targetNamespace = "") String response,
                           @WebParam(name = "hresult", targetNamespace = "") String hresult,
                           @WebParam(name = "message", targetNamespace = "") String message);

    @WebMethod
    String connectionError(@WebParam(name = "ticket", targetNamespace = "") String ticket,
                           @WebParam(name = "hresult", targetNamespace = "") String hresult,
                           @WebParam(name = "message", targetNamespace = "") String message);

    @WebMethod
    String closeConnection(@WebParam(name = "ticket", targetNamespace = "") String ticket);
}
