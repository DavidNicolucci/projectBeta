package com.project3.cliente.repository;


import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project3.cliente.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{

    Optional<Customer> findById(Long id) ;
    
    List<Customer> findAll() ;
    
    boolean existsById(Long id) ;
	
}
