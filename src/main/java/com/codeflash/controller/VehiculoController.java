package com.codeflash.controller;
import com.codeflash.model.Vehiculo;
import com.codeflash.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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

    @PostMapping("/vehiculos")
    public RedirectView salvarVehiculo(Model model, @RequestBody Vehiculo vehiculo) {
         VehiculoRepository.save(vehiculo);
         return new RedirectView("/vehiculos");
    }
    
    @GetMapping("/vehiculos/{id}")
    public String obtenerVehiculoPorId(Model model, @PathVariable String id) {
        Vehiculo vehiculo = VehiculoRepository.findById(id).orElse(null);
        model.addAttribute("vehiculo", vehiculo);
        
        return "vehiculo";
    }

    @DeleteMapping("/vehiculos/{id}")
    public RedirectView borrarPorId(Model model, @PathVariable String id) {
        Vehiculo vehiculo = VehiculoRepository.findById(id).orElse(null);
        VehiculoRepository.delete(vehiculo);
        return new RedirectView("/vehiculos");
    }
    
    @PutMapping("/vehiculos/{id}")
    public RedirectView actualizarVehiculo(Model model, @PathVariable String id, @RequestBody Vehiculo vehiculoActualizado) {
    	Vehiculo vehiculoExistente = VehiculoRepository.findById(id).orElse(null);
        if (vehiculoExistente != null) {
            vehiculoExistente.setMarca(vehiculoActualizado.getMarca());
            vehiculoExistente.setModelo(vehiculoActualizado.getModelo());
            vehiculoExistente.setMatricula(vehiculoActualizado.getMatricula());
            // Actualiza otros atributos según sea necesario
            VehiculoRepository.save(vehiculoExistente);
        }
        return new RedirectView("/vehiculos");
    }
    // Otros métodos para manejar otras operaciones CRUD como GET por ID, PUT, DELETE, etc.
}
