package de.opitzconsulting.spring4.demo.repository;

import de.opitzconsulting.spring4.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
