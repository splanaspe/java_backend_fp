package com.codeflash.controller;
import com.codeflash.model.Cliente;
import com.codeflash.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;
    
    
    @GetMapping("/clientes")
    public String getAllCliente(Model model) {
    	List<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("clientes", clientes); 
        return "listado-clientes"; 
    }

    @PostMapping
    public Cliente createCliente(@RequestBody Cliente Cliente) {
        return clienteRepository.save(Cliente);
    }

    // Otros métodos para manejar otras operaciones CRUD como GET por ID, PUT, DELETE, etc.
}
