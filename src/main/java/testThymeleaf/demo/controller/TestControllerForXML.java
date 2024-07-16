package testThymeleaf.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import testThymeleaf.demo.domain.Response;
import testThymeleaf.demo.dto.UserRequestDto;
import testThymeleaf.demo.entity.PersonEntity;
import testThymeleaf.demo.service.PersonService;
import testThymeleaf.demo.service.XMLService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;
import static testThymeleaf.demo.domain.Response.getResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v2")
public class TestControllerForXML {
    private final PersonService personService;
    private final XMLService xmlService;

    @GetMapping(value = "/test", produces = {MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Response> test(HttpServletRequest request) {
        var usersXML = xmlService.allUsersXML();
        return ResponseEntity.ok().body(getResponse(request, Map.of("users", usersXML), "All users retrieved", HttpStatus.OK));
    }

    @PostMapping(value = "/newUser")
    public ResponseEntity<Response> newUser(@RequestBody UserRequestDto userDto, HttpServletRequest request) {
        personService.addUser(userDto.getEmail(), userDto.getFullname(), userDto.getGender(), userDto.getCountry());
        return ResponseEntity.ok().body(getResponse(request, emptyMap(), "New User Added", HttpStatus.OK));
    }

//    @GetMapping(value = "/test", produces = {MediaType.APPLICATION_XML_VALUE})
//    @ResponseBody
//    public String test() {
//        Context context = new Context();
//        List<PersonEntity> persons = new ArrayList<PersonEntity>();
//
//        PersonEntity abai = new PersonEntity();
//        abai.setFullname("Abai Amangeldiuly");
//        abai.setEmail("abai@gmail.com");
//        abai.setGender("Male");
//        abai.setCity("Almaty");
//        persons.add(abai);
//
//        PersonEntity kuralay = new PersonEntity();
//        kuralay.setFirstName("Kuralay");
//        kuralay.setLastName("Kuralay");
//        kuralay.setEmail("kuralay@gmail.com");
//        kuralay.setGender("Female");
//        kuralay.setCity("Almaty");
//        persons.add(kuralay);
//
//
//        context.setVariable("persons", persons);
//        return templateEngine.process("personDetails", context);
//    }
}
