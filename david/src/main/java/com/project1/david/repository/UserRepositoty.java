package com.project1.david.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project1.david.entity.User;

@Repository
public interface UserRepositoty extends JpaRepository<User,Long>{

       Optional<User> findById(Long id) ;
       
       List<User> findAll() ;
       
       boolean existsById(Long id) ;
    	
       Optional<User> findByFiscalCode(String fiscalcode);

       @Modifying
       @Query("update User u set u.idIndirizzo = :idIndirizzo where u.idUser = :id")
       Integer updateIdIndirizzo(Integer id,Integer idIndirizzo);
   
    	
   
	
	

	
}
