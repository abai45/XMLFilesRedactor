package testThymeleaf.demo.service;

import java.io.IOException;

public interface XMLService {
    String allUsersXML();
    String getXMLContent() throws IOException;
    void saveXML(String xmlContent);
}
