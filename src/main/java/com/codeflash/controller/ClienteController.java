package com.codeflash.controller;
import com.codeflash.model.Cliente;
import com.codeflash.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository ClienteRepository;
    
    @RequestMapping(value = "/clientes", method = RequestMethod.GET)
    public String getAllCliente(Model model) {
    	List<Cliente> clientes = ClienteRepository.findAll();
		model.addAttribute("clientes", clientes); 
        return "listado-clientes"; 
    }

    @PostMapping("/clientes")
    public RedirectView salvarCliente(Model model, @RequestBody Cliente cliente) {
         ClienteRepository.save(cliente);
         return new RedirectView("/clientes");
    }
    
    @GetMapping("/clientes/{id}")
    public String obtenerClientePorId(Model model, @PathVariable String id) {
        Cliente cliente = ClienteRepository.findById(id).orElse(null);
        model.addAttribute("cliente", cliente);
        
        return "cliente";
    }
    
    @GetMapping("/nuevocliente")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente";
    }

    @DeleteMapping("/clientes/{id}")
    public RedirectView borrarPorId(Model model, @PathVariable String id) {
        Cliente cliente = ClienteRepository.findById(id).orElse(null);
        ClienteRepository.delete(cliente);
        return new RedirectView("/clientes");
    }
    
    @PutMapping("/clientes/{id}")
    public RedirectView actualizarCliente(Model model, @PathVariable String id, @RequestBody Cliente clienteActualizado) {
    	Cliente clienteExistente = ClienteRepository.findById(id).orElse(null);
        if (clienteExistente != null) {
        	clienteExistente.setApellido(clienteActualizado.getApellido());
        	clienteExistente.setDireccion(clienteActualizado.getDireccion());
        	clienteExistente.setDocumento(clienteActualizado.getDocumento());
        	clienteExistente.setEmail(clienteActualizado.getEmail());
        	clienteExistente.setIdcliente(clienteActualizado.getIdcliente());
        	clienteExistente.setNombre(clienteActualizado.getNombre());
        	clienteExistente.setTelefono(clienteActualizado.getTelefono());
            ClienteRepository.save(clienteExistente);
        }
        return new RedirectView("/clientes");
    }
}
