package com.codeflash.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.codeflash.model.Vehiculo;

@Repository
public interface VehiculoRepository extends MongoRepository<Vehiculo, String> {
}