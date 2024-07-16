package testThymeleaf.demo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import testThymeleaf.demo.entity.PersonEntity;
import testThymeleaf.demo.repository.PersonRepository;
import testThymeleaf.demo.service.XMLService;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static testThymeleaf.demo.domain.Constant.pathToXML;

@Service
@RequiredArgsConstructor
public class XMLServiceImpl implements XMLService {
    private final PersonRepository personRepository;
    private final TemplateEngine templateEngine;

    @Override
    public String allUsersXML() {
        List<PersonEntity> persons = personRepository.findAll();
        Context context = new Context();
        context.setVariable("personEntities", persons);
        return templateEngine.process("personDetails", context);
    }

    @Override
    public String getXMLContent() throws IOException {
        File file = new File(pathToXML);
        return new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
    }

    @Override
    public void saveXML(String xmlContent) {
        try {
            Files.write(Paths.get(pathToXML), xmlContent.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Failed to save XML: "+ e.getMessage());
        }
    }
}
