package com.codeflash.controller;
import com.codeflash.model.Vehiculo;
import com.codeflash.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class VehiculoController {

    @Autowired
    private VehiculoRepository VehiculoRepository;
    
    @GetMapping("/vehiculos")
    public String getAllVehiculo(Model model) {
    	List<Vehiculo> vehiculos = VehiculoRepository.findAll();
		model.addAttribute("vehiculos", vehiculos); 
        return "listado-vehiculos"; 
    }

    @PostMapping
    public Vehiculo createVehiculo(@RequestBody Vehiculo Vehiculo) {
        return VehiculoRepository.save(Vehiculo);
    }

    // Otros métodos para manejar otras operaciones CRUD como GET por ID, PUT, DELETE, etc.
}
