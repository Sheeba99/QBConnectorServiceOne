package com.example.QBConnectorService;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import org.springframework.stereotype.Service;

import java.util.UUID;

//@WebService(endpointInterface = "com.example.QBConnectorService.QBWService")
@WebService(
        targetNamespace = "http://QBConnectorService.example.com/",
        name = "QBWService"
)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
@Service
public class QBWServiceImpl implements QBWService {

    private static final String TICKET = UUID.randomUUID().toString();

    @Override
    public String checkCompanyFile() {
        // Simulate checking QuickBooks Desktop for a company file
        String companyFile = "C:\\Users\\sheeba\\Documents\\Codecraft.qbw";

        // Simulated response - Ideally, this would query the remote system
        boolean fileExists = checkFileOnRemoteSystem(companyFile);

        if (fileExists) {
            return "Success: QuickBooks company file found!";
        } else {
            return "Error: Company file not found.";
        }
    }

//    @Override
//    @WebMethod(operationName = "authenticate", action = "http://QBConnectorService.example.com/authenticate")
//    public String[] authenticate(String username, String password) {
//        if ("qbuser".equals(username) && "qbpassword".equals(password)) {
//            return new String[]{UUID.randomUUID().toString(), "qbpassword"};
//        }
//        return new String[]{"", ""}; // Authentication failed
//    }
    @WebMethod(operationName = "authenticate", action = "http://developer.intuit.com/authenticate")
    @WebResult(name = "authenticateResponse", targetNamespace = "http://developer.intuit.com/")
    public String[] authenticate(
            @WebParam(name = "strUserName", targetNamespace = "http://developer.intuit.com/") String username,
            @WebParam(name = "strPassword", targetNamespace = "http://developer.intuit.com/") String password) {

        if ("qbuser".equals(username) && "qbpassword".equals(password)) {
            return new String[]{UUID.randomUUID().toString(), "qbpassword"};
        }

        return new String[]{"", ""}; // Authentication failed
    }

    @Override
    public String sendRequestXML(String ticket, String companyFileName, String qbXMLCountry, int qbXMLMajorVers, int qbXMLMinorVers) {
        String companyFile = "C:\\Users\\sheeba\\Documents\\Codecraft.qbw";
        boolean fileExists = checkFileOnRemoteSystem(companyFile);

        if (fileExists) {
            return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<QBXML>\n" +
                    "   <QBXMLMsgsRq onError=\"continueOnError\">\n" +
                    "       <CompanyQueryRq/>\n" +  // QuickBooks will respond with company info
                    "   </QBXMLMsgsRq>\n" +
                    "   <FileStatus>\n" +
                    "       <Message>File is present: " + companyFile + "</Message>\n" +
                    "   </FileStatus>\n" +
                    "</QBXML>";
        } else {
            return "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<QBXML>\n" +
                    "   <FileStatus>\n" +
                    "       <Message>File not present</Message>\n" +
                    "   </FileStatus>\n" +
                    "</QBXML>";
        }
    }

    @Override
    public int receiveResponseXML(String ticket, String response, String hresult, String message) {
        if (response != null && !response.isEmpty()) {
            System.out.println("Received response from QuickBooks: " + response);
            return 100; // 100 means done, 0 means more requests
        }
        return -1; // Error in response
    }

    @Override
    public String connectionError(String ticket, String hresult, String message) {
        return "Error: " + message;
    }

    @Override
    public String closeConnection(String ticket) {
        return "Connection closed successfully";
    }

    private boolean checkFileOnRemoteSystem(String filePath) {
        // Simulate checking for a file in a remote QuickBooks Desktop system
        return true; // Assume the file exists for now
    }

    @WebMethod(operationName = "clientVersion")
    @WebResult(name = "clientVersionResponse", targetNamespace = "http://QBConnectorService.example.com/")
    public String clientVersion(@WebParam(name = "strVersion") String strVersion) {
        return "1.0"; // Returning a dummy version for compatibility
    }

}
