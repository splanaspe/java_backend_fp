package com.codeflash.controller;
import com.codeflash.model.Alquiler;
import com.codeflash.repository.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
public class AlquilerController {

    @Autowired
    private AlquilerRepository AlquilerRepository;
    
    @GetMapping("/alquileres")
    public String getAllAlquiler(Model model) {
    	List<Alquiler> alquileres = AlquilerRepository.findAll();
		model.addAttribute("alquileres", alquileres); 
        return "listado-alquileres"; 
    }

    @PostMapping("/alquileres")
    public RedirectView salvarAlquiler(Model model, @RequestBody Alquiler alquiler) {
         AlquilerRepository.save(alquiler);
         return new RedirectView("/alquileres");
    }
    
    @GetMapping("/alquileres/{id}")
    public String obtenerAlquilerPorId(Model model, @PathVariable String id) {
        Alquiler alquiler = AlquilerRepository.findById(id).orElse(null);
        model.addAttribute("alquiler", alquiler);
        
        return "alquiler";
    }

    @DeleteMapping("/alquileres/{id}")
    public RedirectView borrarPorId(Model model, @PathVariable String id) {
        Alquiler alquiler = AlquilerRepository.findById(id).orElse(null);
        AlquilerRepository.delete(alquiler);
        return new RedirectView("/alquileres");
    }
    
    @PutMapping("/alquileres/{id}")
    public RedirectView actualizarAlquiler(Model model, @PathVariable String id, @RequestBody Alquiler alquilerActualizado) {
    	Alquiler alquilerExistente = AlquilerRepository.findById(id).orElse(null);
        if (alquilerExistente != null) {
        	alquilerExistente.setCliente(alquilerActualizado.getCliente());
        	alquilerExistente.setFechaFin(alquilerActualizado.getFechaFin());
        	alquilerExistente.setFechaInicio(alquilerActualizado.getFechaInicio());
        	alquilerExistente.setIdalquiler(alquilerActualizado.getIdalquiler());
        	alquilerExistente.setPrecio(alquilerActualizado.getPrecio());
        	alquilerExistente.setVehiculo(alquilerActualizado.getVehiculo());
            AlquilerRepository.save(alquilerExistente);
        }
        return new RedirectView("/alquileres");
    }
}
