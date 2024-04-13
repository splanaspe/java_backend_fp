package com.codeflash.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.codeflash.model.Alquiler;


@Repository
public interface AlquilerRepository extends MongoRepository<Alquiler, String> {
    
	
}