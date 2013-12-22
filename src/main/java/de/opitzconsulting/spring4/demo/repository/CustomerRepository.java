package de.opitzconsulting.spring4.demo.repository;

import de.opitzconsulting.spring4.demo.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
