package com.codeflash.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codeflash.model.Alquiler;


@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, String> {
    
	
}