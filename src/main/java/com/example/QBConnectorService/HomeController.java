package com.example.QBConnectorService;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping(produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<String> home() {
        String soapResponse =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                        "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                        "    <soap:Body>\n" +
                        "        <checkCompanyFileResponse xmlns=\"http://example.com/qb\">\n" +
                        "            <return>Welcome to QB Connector Service. SOAP Service is available at /services/qbwService</return>\n" +
                        "        </checkCompanyFileResponse>\n" +
                        "    </soap:Body>\n" +
                        "</soap:Envelope>";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_XML);

        return new ResponseEntity<>(soapResponse, headers, HttpStatus.OK);
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
