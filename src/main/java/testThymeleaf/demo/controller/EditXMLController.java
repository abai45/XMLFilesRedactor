package testThymeleaf.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testThymeleaf.demo.domain.Response;
import testThymeleaf.demo.service.XMLService;

import java.io.IOException;
import java.util.Map;

import static java.util.Collections.emptyMap;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EditXMLController {

    private final XMLService xmlService;

    @GetMapping("/xml")
    @ResponseBody
    public ResponseEntity<Response> getXMLContent(HttpServletRequest request) throws IOException {
        var xmlContent = xmlService.getXMLContent();
        return ResponseEntity.ok().body(Response.getResponse(request, Map.of("xmlContent",xmlContent), "XML Content retrieved", HttpStatus.OK));
    }

    @PostMapping("/saveXml")
    @ResponseBody
    public ResponseEntity<Response> saveXml(@RequestBody String xmlContent, HttpServletRequest request) {
        xmlService.saveXML(xmlContent);
        return ResponseEntity.ok().body(Response.getResponse(request, emptyMap(), "XML Content saved", HttpStatus.OK));
    }
}
