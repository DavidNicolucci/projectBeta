package com.project2.indirizzo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project2.indirizzo.entity.MasterData;

@Repository
public interface MasterDataRepository extends JpaRepository <MasterData,Long> {

	
    Optional<MasterData> findById(Long id) ;
    
    List<MasterData> findAll() ;
    
    boolean existsById(Long id) ;
	
}
