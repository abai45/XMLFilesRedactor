package testThymeleaf.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testThymeleaf.demo.entity.PersonEntity;
import testThymeleaf.demo.repository.PersonRepository;
import testThymeleaf.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public void addUser(String email, String fullname, String gender, String city) {
        PersonEntity person = new PersonEntity();
        person.setEmail(email);
        person.setFullname(fullname);
        person.setGender(gender);
        person.setCity(city);
        personRepository.save(person);
    }


}
