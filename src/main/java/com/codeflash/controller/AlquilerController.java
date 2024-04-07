package com.codeflash.controller;

import com.codeflash.model.Alquiler;
import com.codeflash.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class AlquilerController {

    @Autowired
    private AlquilerRepository AlquilerRepository;
    @GetMapping ("/Alquiler")
    public String getAllAlquiler(Model model) {
    	List<Alquiler> Alquileres = AlquilerRepository.findAll();
		model.addAttribute("alquileres", Alquileres); 
        return "listado-Alquileres"; 
    }
    
    @PostMapping
    public Alquiler createAlquiler(@RequestBody Alquiler Alquiler) {
        return AlquilerRepository.save(Alquiler);
    }

    // Otros métodos para manejar otras operaciones CRUD como GET por ID, PUT, DELETE, etc.
}
