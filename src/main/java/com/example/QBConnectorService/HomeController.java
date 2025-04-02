package com.example.QBConnectorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

//@RestController
//@RequestMapping("/")
//public class HomeController {
//
//    @GetMapping(produces = MediaType.TEXT_XML_VALUE)
//    public ResponseEntity<String> home() {
//        String soapResponse =
//                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
//                        "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
//                        "    <soap:Body>\n" +
//                        "        <checkCompanyFileResponse xmlns=\"http://example.com/qb\">\n" +
//                        "            <return>Welcome to QB Connector Service. SOAP Service is available at /services/qbwService</return>\n" +
//                        "        </checkCompanyFileResponse>\n" +
//                        "    </soap:Body>\n" +
//                        "</soap:Envelope>";
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.TEXT_XML);
//
//        return new ResponseEntity<>(soapResponse, headers, HttpStatus.OK);
//    }
//}

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public void redirectToSoapService(HttpServletResponse response) throws IOException {
        response.sendRedirect("/services/qbwService?wsdl"); // Redirects to the SOAP service WSDL.
    }
}


//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class HomeController {
//
//    @GetMapping("/")
//    public ResponseEntity<String> home() {
//        return ResponseEntity.ok("Welcome to QB Connector Service. SOAP Service is available at /services/qbwService");
//    }
//}
