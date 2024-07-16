package testThymeleaf.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import testThymeleaf.demo.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
